package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRegistro
 */
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String apellidos=request.getParameter("apellidos");
		String password=request.getParameter("password");
		String direccion=request.getParameter("direccion");
		String codigoPostal=request.getParameter("codigoPostal");
		String municipio=request.getParameter("municipio");
		String provincia=request.getParameter("provincia");
		String pais=request.getParameter("pais");
		String telefono=request.getParameter("telefono");
		String email=request.getParameter("email");
		String descripcion=request.getParameter("descripcion");
		if(usuario.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(apellidos.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(password.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(direccion.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(codigoPostal.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(municipio.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(provincia.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(pais.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(telefono.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(email.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
		else if(descripcion.equals("")) {
			response.sendRedirect("html/registro.jsp?error=CV");
		}
	}

}
