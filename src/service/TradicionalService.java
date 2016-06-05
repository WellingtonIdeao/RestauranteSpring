package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ItemPedidoDAO;
import dao.TradicionalDAO;
import model.ItemPedido;
import model.Pedido;
import model.Tradicional;

@Service
@Transactional
public class TradicionalService extends AbstractService<Tradicional> {
	@Autowired
	private ItemPedidoDAO ipdao;
	@Autowired
	private TradicionalDAO dao;
	
	public void inserir(Tradicional t) {
		try {
			// se pedido for nulo
			if (t == null) {
				throw new Exception("Entidade passada para inser��o � nula");
			}
			// se n�o existir mesa
			if (t.getMesa() == null)
				throw new Exception("Pedido Tradicional sem mesa");
			// se n�o tiver item no Pedido
			if (t.getItens().isEmpty())
				throw new Exception("Pedido Tradicional sem itens");
//			// inserindo os itens com produtos no BD
			for (ItemPedido i : t.getItens()) {
				if (i.getProduto() == null)
					throw new Exception("Item pedido sem produto");
				i.setPedido(t);
				ipdao.inserir(i);

			}
			dao.inserir(t);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean atualizar(Tradicional t) {
		boolean ret = false;
		try {
			// se entidade for nula
			if (t == null) {
				throw new Exception("Entidade passada para atualiza��o � nula");
			}
			dao.atualizar(t);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public boolean remover(Tradicional t) {
		boolean ret = false;
		try {
			// se entidade for nula
			if (t == null) {
				throw new Exception("Entidade passada para remo��o � nula");

			} else
				t = dao.buscarPorId(t.getId());

			// se entidade n�o estiver BD
			if (t == null)
				throw new Exception("Entidade passada para remo��o n�o encontrada");

			// removendo cada item antes de pedido
			for (ItemPedido i : t.getItens()) {
				ipdao.remover(i);
			}

			dao.remover(t);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}

	public List<Tradicional> listar() {
		List<Tradicional> list = null;
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

	public Tradicional buscar(Tradicional t) {
		try {
			// se entidade for nula
			if (t == null)
				throw new Exception("Entidade passada para busca � nula");
			else
				t = dao.buscarPorId(t.getId());

			// se entidade n�o estiver no BD
			if (t == null)
				throw new Exception(simpleName(t) + " n�o encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return t;
	}

	public String simpleName(Tradicional t) {
		return t.getClass().getSimpleName();

	}
	 public List<Pedido> buscarFiltro(Pedido filtro){
		 return dao.buscarFiltro(filtro);
	 }

}
