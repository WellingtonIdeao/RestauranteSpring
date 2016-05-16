package dao;

import model.Delivery;

public class DeliveryDAO extends PadraoDAO<Delivery> {

	@Override
	public Class<Delivery> entityClass() {
		return Delivery.class;
	}
	

}
