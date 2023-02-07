package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.ClienteDAO;


/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("a");
		if (request.getParameter("todoOk") != null) {
			if (request.getSession(false) != null)
				request.getSession().invalidate();
			request.getSession();
			String codError = "";
			if (request.getParameter("usuario").equals("")) {
				codError += "1";
			}
			if (request.getParameter("password").equals("")) {
				codError += "2";
			}
			if (!codError.equals(""))
				request.getRequestDispatcher("login.jsp?codError=" + codError).forward(request, response);
			else {
				ClienteDAO cd = new ClienteDAO();
				Usuario user = cd.buscaCliente(request.getParameter("usuario"), 
												request.getParameter("password"));
				if (user == null)
					request.getRequestDispatcher("login.jsp?codError=3").forward(request, response);
//				Añadir Cliente a la session
				request.getSession().setAttribute("cliente", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
