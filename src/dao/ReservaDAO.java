package dao;

import model.Reserva;

public class ReservaDAO extends PadraoDAO<Reserva> {

	@Override
	public Class<Reserva> entityClass() {
		return Reserva.class;
	}

}
