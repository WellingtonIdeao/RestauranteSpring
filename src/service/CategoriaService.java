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
				throw new Exception("Entidade passada para inserção é nula");
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
				throw new Exception("Entidade passada para atualização é nula");
			}

			// se não for nula
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
				throw new Exception("Entidade passada para remoção é nula");

			} else
				cat = dao.buscarPorId(cat.getId());

			// se entidade não estiver BD
			if (cat == null)
				throw new Exception("Entidade passada para remoção não encontrada");

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
				throw new Exception("Lista está vazia");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return list;
	}

	public Categoria buscar(Categoria cat) {
		try {
			// se entidade for nula
			if (cat == null)
				throw new Exception("Entidade passada para busca é nula");
			else
				cat = dao.buscarPorId(cat.getId());

			// se entidade não estiver no BD
			if (cat == null)
				throw new Exception(simpleName(cat) + " não encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cat;
	}

	public String simpleName(Categoria cat) {
		return cat.getClass().getSimpleName();

	}

}
