package dao;

import model.ItemPedido;

public class ItemPedidoDAO extends PadraoDAO<ItemPedido> {

	@Override
	public Class<ItemPedido> entityClass() {
		return ItemPedido.class;
	}

}
