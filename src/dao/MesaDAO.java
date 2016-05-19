package dao;
import org.springframework.stereotype.Repository;
import model.Mesa;

@Repository
public class MesaDAO extends PadraoDAO<Mesa> {

	@Override
	public Class<Mesa> entityClass() {
		return Mesa.class;
	}

}
