package dao;
import org.springframework.stereotype.Repository;
import model.Delivery;

@Repository
public class DeliveryDAO extends PadraoDAO<Delivery> {

	@Override
	public Class<Delivery> entityClass() {
		return Delivery.class;
	}
	

}
