package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LineaPedido;
import beans.VideoJuego;
import dao.JuegosDAO;

/**
 * Servlet implementation class ServletCarritoCompra
 */
public class ServletCarritoCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarritoCompra() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("idJuego") != null && request.getParameter("idJuego") != "") {
			int idJuego = Integer.parseInt(request.getParameter("idJuego"));
			if (estaLaSesionIniciada(request)) {
				HashMap<Integer, LineaPedido> carrito = obtenerCarritoDeSesion(request);
				if (carrito == null)
					carrito = new HashMap<Integer, LineaPedido>();
				LineaPedido lp = null;
				if (carrito.containsKey(idJuego)) {
					lp = carrito.get(idJuego);
				} else {
					JuegosDAO jDao = new JuegosDAO();
					VideoJuego juego = jDao.obtenerJuegoPorId(idJuego);
					lp = new LineaPedido(1, juego);
				}
				carrito.put(idJuego, lp);
				request.getSession().setAttribute("carrito", lp);
				response.sendRedirect("ServletJuego?idJuego="+idJuego+"&aniadio");
			} else
				response.sendRedirect("ServletJuego?idJuego="+idJuego+"&noSession");
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private HashMap<Integer, LineaPedido> obtenerCarritoDeSesion(HttpServletRequest request) {
		HashMap<Integer, LineaPedido> carrito = null;
		if (request.getSession().getAttribute("carrito") != null)
			carrito = (HashMap<Integer, LineaPedido>) request.getSession().getAttribute("carrito");
		return carrito;
	}
	private boolean estaLaSesionIniciada(HttpServletRequest request) {
		if (request.getSession().getAttribute("usuario") != null) 
			return true;
		return false;
		
	}
}
