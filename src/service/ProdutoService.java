package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProdutoDAO;
import model.Cardapio;
import model.Produto;

@Service
@Transactional
public class ProdutoService extends AbstractService<Produto> {

	@Autowired
	ProdutoDAO dao;
	
	public void inserir(Produto p) {
		try {
			// se o produto for nulo
			if (p == null)
				throw new Exception("Entidade passada para inserção é nula");

			// se o produto não possui categoria
			if (p.getCategoria() == null) {
				throw new Exception("Produto Sem categoria");
			}
			dao.inserir(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	

	}

	public boolean atualizar(Produto p) {
		
		boolean ret = false;
		try {
			// se entidade for nula
			if (p == null)
				throw new Exception("Entidade passada para atualização é nula");

			// se entidade não tiver cardapio
			if (p.getCategoria() == null)
				throw new Exception("Produto Sem categoria");

			dao.atualizar(p);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}

	public List<Produto> listar() {
		List<Produto> list = null;
		try {
			list = dao.listar();
			// se a lista for vazia
			if (list.isEmpty())
				throw new Exception("Lista está vazia");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return list;
	}

	public Produto buscar(Produto pro) {
		try {
			// se entidade for nula
			if (pro == null)
				throw new Exception("Entidade passada para busca é nula");
			else
				pro = dao.buscarPorId(pro.getId());

			// se entidade não estiver no BD
			if (pro == null)
				throw new Exception(simpleName(pro) + " não encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pro;
	}
	public boolean remover(Produto pro) {
		boolean ret = false;
		try {

			// se entidade for nula
			if (pro == null) {
				throw new Exception("Entidade passada para remoção é nula");

			} else
				 pro = dao.buscarPorId(pro.getId());

			// se entidade não estiver BD
			if ( pro== null)
				throw new Exception("Entidade passada para remoção não encontrada");

			dao.remover(pro);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}

	public String simpleName(Produto pro) {
		return pro.getClass().getSimpleName();

	}
	public List<Produto> buscarFiltro(Produto filtro){
		return  dao.buscarFiltro(filtro);
	}

}
