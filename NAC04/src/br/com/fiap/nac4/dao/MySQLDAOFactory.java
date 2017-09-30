package br.com.fiap.nac4.dao;

import br.com.fiap.nac4.dao.impl.mysql.MySQLUsuarioDAO;
import br.com.fiap.nac4.dao.interfaces.UsuarioDAO;

public class MySQLDAOFactory extends DAOFactory {
	
	@Override
	public UsuarioDAO getUsuarioDAO() {
		
		return new MySQLUsuarioDAO();
		
	}

}
