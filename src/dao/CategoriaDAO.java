package dao;

import model.Categoria;

public class CategoriaDAO extends PadraoDAO<Categoria> {

	@Override
	public Class<Categoria> entityClass() {
		return Categoria.class;
	}

}
