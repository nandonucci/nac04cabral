package br.com.fiap.nac4.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.nac4.beans.Usuario;
import br.com.fiap.nac4.dao.DAOFactory;

@WebServlet("/RegistrarServlet")
public class RegistrarServlet extends HttpServlet{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String usuarioEmail = req.getParameter("register-email");
	        String senha = req.getParameter("register-password");

	        Usuario usuario = new Usuario(usuarioEmail, senha);

	        DAOFactory.getDAOFactory(DAOFactory.MYSQL).getUsuarioDAO().registrarUsuario(usuario);

	        HttpSession session = req.getSession();
	        session.setAttribute("usuario", usuario.getUsuario());
	        req.getRequestDispatcher("/loginOK.jsp").forward(req, resp);

	    }

}
