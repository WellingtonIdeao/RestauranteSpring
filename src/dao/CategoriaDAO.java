package dao;

import org.springframework.stereotype.Repository;
import model.Categoria;

@Repository
public class CategoriaDAO extends PadraoDAO<Categoria> {

	@Override
	public Class<Categoria> entityClass() {
		return Categoria.class;
	}

}
