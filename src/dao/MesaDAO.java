package dao;

import model.Mesa;

public class MesaDAO extends PadraoDAO<Mesa> {

	@Override
	public Class<Mesa> entityClass() {
		return Mesa.class;
	}

}
