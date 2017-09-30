package br.com.fiap.nac4.dao;

import br.com.fiap.nac4.dao.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	
	private static DAOFactory mysqlDaoFactory = null;
	
	public static DAOFactory getDAOFactory(int repositorio) {
		switch (repositorio) {
		case MYSQL:
			
			if (mysqlDaoFactory == null) {
				mysqlDaoFactory = new MySQLDAOFactory();
				
				return mysqlDaoFactory;
				
			}
		default:
			return null;
		}		
	}
	
	public abstract UsuarioDAO getUsuarioDAO();

}
