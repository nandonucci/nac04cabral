package br.com.fiap.nac4.dao.impl.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionManager {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String JDBCURL = "jdbc:mysql://localhost:3306/nac04";
	private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	
	private static ConnectionManager instancia;
	
	private ConnectionManager() throws ClassNotFoundException{
		
		//Aqui o driver � registrado
		Class.forName(DRIVER_MYSQL);		
	}
	
	//Pegando a instancia da classe
	
	static ConnectionManager getInstancia() throws SQLException{
		try {
			if (instancia == null) {
				instancia = new ConnectionManager();
			}
		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver JDBC n�o foi localizado!!");
		}
		return instancia;
	}
	
	//Abrindo a conex�o com o banco
	
	Connection getConnection() throws SQLException{
		try {
			return DriverManager.getConnection(JDBCURL, USUARIO, SENHA);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Conex�o com o banco falhou!! ", e);
		}
	}	

}
