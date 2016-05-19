package dao;

import org.springframework.stereotype.Repository;
import model.Cliente;

@Repository
public class ClienteDAO extends PadraoDAO<Cliente> {

	@Override
	public Class<Cliente> entityClass() {
		return Cliente.class;
	}
	 

}
