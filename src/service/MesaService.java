package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MesaDAO;
import model.Mesa;
import model.Mesa;

@Service
@Transactional
public class MesaService extends AbstractService<Mesa> {	
	
	@Autowired
	private MesaDAO dao;
	public void inserir(Mesa m) {
		try {	
			// se a mesa for nula
			if (m == null)
				throw new Exception("Entidade passada para inserção é nula");

			dao.inserir(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean atualizar(Mesa m) {
		boolean ret = false;
		try {
			// se entidade for nula
			if (m == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}

			// se não for nula
			dao.atualizar(m);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}
	
	public boolean remover(Mesa m) {
		boolean ret = false;
		try {

			// se entidade for nula
			if (m == null) {
				throw new Exception("Entidade passada para remoção é nula");

			} else
				m = dao.buscarPorId(m.getId());

			// se entidade não estiver BD
			if (m == null)
				throw new Exception("Entidade passada para remoção não encontrada");

			dao.remover(m);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}

	public List<Mesa> listar() {
		List<Mesa> list = null;
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

	public Mesa buscar(Mesa m) {
		try {
			// se entidade for nula
			if (m == null)
				throw new Exception("Entidade passada para busca é nula");
			else
				m = dao.buscarPorId(m.getId());

			// se entidade não estiver no BD
			if (m == null)
				throw new Exception(simpleName(m) + " não encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return m;
	}

	public String simpleName(Mesa m) {
		return m.getClass().getSimpleName();

	}
	public List<Mesa> buscarFiltro(Mesa filtro){
		return  dao.buscarFiltro(filtro);
	}


}
