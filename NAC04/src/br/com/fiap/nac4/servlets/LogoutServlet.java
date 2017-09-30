package br.com.fiap.nac4.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	        if(req.getSession() != null){
	            req.getSession().removeAttribute("usuario");
	            req.getSession().invalidate();
	            resp.sendRedirect( req.getContextPath() + "/index.jsp");
	        }

	    }
}
