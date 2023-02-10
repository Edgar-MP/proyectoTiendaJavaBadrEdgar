package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.ClienteDAO;

public class ServletListadoCompanias extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("obtenerCompanias")==null) {
			response.sendRedirect("html/listadoDeCompanias.jsp");
		}
		else {
			System.out.println("entra");
			ClienteDAO cd = new ClienteDAO();
			ArrayList<Usuario> usuarios=cd.listarUsuarios();
			request.getSession().setAttribute("usuarios", usuarios);
			response.sendRedirect("html/listadoDeUsuarios.jsp");
		}
		
	}

}
