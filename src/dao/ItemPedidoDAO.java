package dao;

import org.springframework.stereotype.Repository;
import model.ItemPedido;

@Repository
public class ItemPedidoDAO extends PadraoDAO<ItemPedido> {

	@Override
	public Class<ItemPedido> entityClass() {
		return ItemPedido.class;
	}

}
