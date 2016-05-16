package dao;

import model.Tradicional;

public class TradicionalDAO extends PadraoDAO<Tradicional> {

	@Override
	public Class<Tradicional> entityClass() {
		return Tradicional.class;
	}

}
