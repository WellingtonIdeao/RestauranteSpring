package dao;

import model.Cliente;

public class ClienteDAO extends PadraoDAO<Cliente> {

	@Override
	public Class<Cliente> entityClass() {
		return Cliente.class;
	}
	 

}
