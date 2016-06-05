package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DeliveryDAO;
import dao.ItemPedidoDAO;
import model.Delivery;
import model.Funcionario;
import model.ItemPedido;
import model.Pedido;
import model.Usuario;

@Service
@Transactional
public class DeliveryService extends AbstractService<Delivery> {
	
	@Autowired
	private ItemPedidoDAO ipdao;
	@Autowired
	private DeliveryDAO dao;
	
	public void inserir(Delivery d) {

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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean atualizar(Delivery d) {
		boolean ret = false;
		try {
			// se entidade for nula
			if (d == null) {
				throw new Exception("Entidade passada para atualiza��o � nula");
			}

			dao.atualizar(d);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public boolean remover(Delivery d) {
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
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}
	
	public List<Delivery> listar() {
		List<Delivery> list = null;
		try {
			list = dao.listar();
			// se a lista for vazia
			if (list.isEmpty())
				throw new Exception("Lista est� vazia");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return list;
	}

	public Delivery buscar(Delivery d) {
		try {
			// se entidade for nula
			if (d == null)
				throw new Exception("Entidade passada para busca � nula");
			else
				d = dao.buscarPorId(d.getId());

			// se entidade n�o estiver no BD
			if (d == null)
				throw new Exception(simpleName(d) + " n�o encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return d;
	}

	public String simpleName(Delivery d) {
		return d.getClass().getSimpleName();

	}
	public List<Pedido> buscarFiltro(Pedido filtro){
		return  dao.buscarFiltro(filtro);
	}
	public List<Delivery> buscarFiltroDelivery(Delivery filtro) {
		return dao.buscarFiltroDelivery(filtro);
	}
	public List<Delivery> listarPorCliente(Usuario user) {
		List<Delivery> list = null;
		try {
			list = dao.listarPorCliente(user);
			// se a lista for vazia
			if (list.isEmpty())
				throw new Exception("Lista est� vazia");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return list;
	}


}
