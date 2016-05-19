package dao;
import org.springframework.stereotype.Repository;
import model.Produto;

@Repository
public class ProdutoDAO extends PadraoDAO<Produto> {

	@Override
	public Class<Produto> entityClass() {
		return Produto.class;
	}

}
