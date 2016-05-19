package dao;
import org.springframework.stereotype.Repository;
import model.Tradicional;

@Repository
public class TradicionalDAO extends PadraoDAO<Tradicional> {

	@Override
	public Class<Tradicional> entityClass() {
		return Tradicional.class;
	}

}
