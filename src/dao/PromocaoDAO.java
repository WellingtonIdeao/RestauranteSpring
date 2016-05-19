package dao;
import org.springframework.stereotype.Repository;
import model.Promocao;

@Repository
public class PromocaoDAO extends PadraoDAO<Promocao> {

	@Override
	public Class<Promocao> entityClass() {
		return Promocao.class;
	}

}
