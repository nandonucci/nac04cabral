package br.com.fiap.nac4.bo;

import java.sql.SQLException;

import br.com.fiap.nac4.beans.Usuario;
import br.com.fiap.nac4.dao.DAOFactory;

public class UsuarioBO {
	
	public boolean validarUsuario(Usuario usuario) throws SQLException {
		
		boolean isUsuarioValido = false;
		
		if (usuario.getSenha().equals(DAOFactory.getDAOFactory(1).getUsuarioDAO().getSenha(usuario))) {
			isUsuarioValido = true;		
		
		}
		
		return isUsuarioValido;
	}

}
