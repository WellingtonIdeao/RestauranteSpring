package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.ItemPedidoDAO;
import model.ItemPedido;
import model.Tradicional;

@Service
@Transactional
public class TradicionalService extends AbstractService<Tradicional> {
	@Autowired
	private ItemPedidoDAO ipdao;
	

	@Override
	public void inserir(Tradicional t) {
		manager = fac.createEntityManager();

		try {
			// se pedido for nulo
			if (t == null) {
				throw new Exception("Entidade passada para inserção é nula");
			}
			// se não existir mesa
			if (t.getMesa() == null)
				throw new Exception("Pedido Tradicional sem mesa");

			// se não tiver item no Pedido
			if (t.getItens().isEmpty())
				throw new Exception("Pedido Tradicional sem itens");

			// inserindo os itens com produtos no BD
			for (ItemPedido i : t.getItens()) {
				if (i.getProduto() == null)
					throw new Exception("Item pedido sem produto");
				i.setPedido(t);
				ipdao.inserir(i);

			}

			dao.inserir(t);
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
	public boolean atualizar(Tradicional t) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			// se entidade for nula
			if (t == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}

			dao.atualizar(t);
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
	public boolean remover(Tradicional t) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			// se entidade for nula
			if (t == null) {
				throw new Exception("Entidade passada para remoção é nula");

			} else
				t = dao.buscarPorId(t.getId());

			// se entidade não estiver BD
			if (t == null)
				throw new Exception("Entidade passada para remoção não encontrada");

			// removendo cada item antes de pedido
			for (ItemPedido i : t.getItens()) {
				ipdao.remover(i);
			}

			dao.remover(t);
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
