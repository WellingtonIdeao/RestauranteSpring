package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CategoriaDAO;
import model.Categoria;

@Service
@Transactional
public class CategoriaService extends AbstractService<Categoria> {
	
	@Autowired
	private CategoriaDAO dao;

	public void inserir(Categoria c) {
		try {
			// se a categoria for nula
			if (c == null)
				throw new Exception("Entidade passada para inser��o � nula");
			dao.inserir(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public boolean atualizar(Categoria c) {
		boolean ret = false;
		try {
			// se entidade for nula
			if (c == null) {
				throw new Exception("Entidade passada para atualiza��o � nula");
			}

			// se n�o for nula
			dao.atualizar(c);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}
	
	public boolean remover(Categoria cat) {
		boolean ret = false;
		try {

			// se entidade for nula
			if (cat == null) {
				throw new Exception("Entidade passada para remo��o � nula");

			} else
				cat = dao.buscarPorId(cat.getId());

			// se entidade n�o estiver BD
			if (cat == null)
				throw new Exception("Entidade passada para remo��o n�o encontrada");

			dao.remover(cat);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}

	public List<Categoria> listar() {
		List<Categoria> list = null;
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

	public Categoria buscar(Categoria cat) {
		try {
			// se entidade for nula
			if (cat == null)
				throw new Exception("Entidade passada para busca � nula");
			else
				cat = dao.buscarPorId(cat.getId());

			// se entidade n�o estiver no BD
			if (cat == null)
				throw new Exception(simpleName(cat) + " n�o encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	public String simpleName(Categoria cat) {
		return cat.getClass().getSimpleName();

	}
	public List<Categoria> buscarFiltro(Categoria filtro){
		return  dao.buscarFiltro(filtro);
	}

}
