package br.com.fiap.nac4.dao.impl.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.nac4.beans.Usuario;
import br.com.fiap.nac4.dao.interfaces.UsuarioDAO;

public class MySQLUsuarioDAO implements UsuarioDAO {
	Connection connection;
	final String  SEL_PASSWORD_BD = "SELECT senha FROM nac04.usuario WHERE usuario = ?";
	final String  SEL_USUARIO_BD = "SELECT usuario FROM nac04.usuario WHERE usuario = ?";

	//Variável rs é abreviação de ResultSet
	//Variável stmt é abreviação de PreparedStatement

	@Override
	public String getSenha(Usuario usuario) throws SQLException {

		try {

			connection = ConnectionManager.getInstancia().getConnection();
			PreparedStatement stmt = connection.prepareStatement(SEL_PASSWORD_BD);		

			stmt.setString(1, usuario.getUsuario());
			ResultSet rs = stmt.executeQuery();


			String consultarSenha = rs.getString("senha");

			connection.close();

			return consultarSenha;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro de conexão ", e);
		}		
	}

	@Override
	public String getUsuario(Usuario usuario) throws SQLException {
		try {

			connection = ConnectionManager.getInstancia().getConnection();
			PreparedStatement stmt = connection.prepareStatement(SEL_USUARIO_BD);		

			stmt.setString(1, usuario.getUsuario());
			ResultSet rs = stmt.executeQuery();


			String consultarSenha = rs.getString("usuario");

			connection.close();

			return consultarSenha;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro de conexão ", e);
		}		

	}

	@Override
	public void dropUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet getLogin(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
