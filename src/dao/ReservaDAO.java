package dao;
import org.springframework.stereotype.Repository;
import model.Reserva;

@Repository
public class ReservaDAO extends PadraoDAO<Reserva> {

	@Override
	public Class<Reserva> entityClass() {
		return Reserva.class;
	}

}
