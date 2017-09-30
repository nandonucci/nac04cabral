package br.com.fiap.nac4.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.nac4.beans.Usuario;

public interface UsuarioDAO {
	
	String getUsuario(Usuario usario) throws SQLException;
	String getSenha(Usuario usuario) throws SQLException;
	
	void dropUsuario(Usuario usuario);
	void registrarUsuario(Usuario usuario);
	
	ResultSet getLogin(Usuario usuario);
	
}
