package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.DeliveryDAO;
import dao.ItemPedidoDAO;
import model.Delivery;
import model.ItemPedido;

@Service
@Transactional
public class DeliveryService extends AbstractService<Delivery> {
	
	@Autowired
	private ItemPedidoDAO ipdao;
	
	@Override
	public void inserir(Delivery d) {
		manager = fac.createEntityManager();

		try {
			// se o pedido for nulo
			if (d == null)
				throw new Exception("Entidade passada para inser��o � nula");
			// se n�o existir cliente
			if (d.getCliente() == null)
				throw new Exception("Delivery sem cliente");

			// se n�o tiver item no pedido
			if (d.getItens().isEmpty())
				throw new Exception("Delivery sem item");

			// inserindo os itens com produtos no BD
			for (ItemPedido i : d.getItens()) {
				if (i.getProduto() == null)
					throw new Exception("Item pedido sem produto");
				i.setPedido(d); // refer�ncia do pedido em cada item / bidirecional
				ipdao.inserir(i);
			}

			dao.inserir(d);
			manager.getTransaction().begin();
			manager.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();

		} finally {
			manager.close();
		}
	}

	@Override
	public boolean atualizar(Delivery d) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			// se entidade for nula
			if (d == null) {
				throw new Exception("Entidade passada para atualiza��o � nula");
			}

			dao.atualizar(d);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return ret;
	}

	@Override
	public boolean remover(Delivery d) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			// se entidade for nula
			if (d == null) {
				throw new Exception("Entidade passada para remo��o � nula");

			} else
				d = dao.buscarPorId(d.getId());

			// se entidade n�o estiver BD
			if (d == null)
				throw new Exception("Entidade passada para remo��o n�o encontrada");

			// removendo cada item antes de pedido
			for (ItemPedido i : d.getItens()) {
				ipdao.remover(i);
			}

			dao.remover(d);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return ret;
	}

}
