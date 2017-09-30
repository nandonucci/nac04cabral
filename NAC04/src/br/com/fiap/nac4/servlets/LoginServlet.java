package br.com.fiap.nac4.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.nac4.beans.Usuario;
import br.com.fiap.nac4.bo.UsuarioBO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioBO usuarioBO = new UsuarioBO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String getUsuario = req.getParameter("usuario-login");
		String getSenha = req.getParameter("usuario-senha");
		
		Usuario usuario = new Usuario(getUsuario, getSenha);
		
		HttpSession session = req.getSession();
		
		try {
			if (usuarioBO.validarUsuario(usuario)) {
				if (!(session.isNew())) {
					session = req.getSession();
					session.setAttribute("usuario", usuario.getUsuario());
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginOK.jsp");
					requestDispatcher.forward(req, resp);
				} else {
					String alertUsuarioSenha = "Usuário ou senha inválido!";
					req.setAttribute("alertUsuarioSenha", alertUsuarioSenha);
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}
			}
		} catch (SQLException e) {
			String error = e.getMessage();
			req.setAttribute("error", error);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	
}
