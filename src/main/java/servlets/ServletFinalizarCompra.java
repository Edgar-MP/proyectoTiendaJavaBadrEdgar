package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFinalizarCompra() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("total") != null) {
			double total = Double.parseDouble(request.getParameter("total"));
			response.sendRedirect("html/finalizarCompra.jsp?total="+total);
		} else {
			response.sendRedirect("index.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
