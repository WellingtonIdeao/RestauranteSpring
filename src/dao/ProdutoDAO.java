package dao;

import model.Produto;

public class ProdutoDAO extends PadraoDAO<Produto> {

	@Override
	public Class<Produto> entityClass() {
		return Produto.class;
	}

}
