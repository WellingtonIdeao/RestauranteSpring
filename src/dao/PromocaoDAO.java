package dao;

import model.Promocao;

public class PromocaoDAO extends PadraoDAO<Promocao> {

	@Override
	public Class<Promocao> entityClass() {
		return Promocao.class;
	}

}
