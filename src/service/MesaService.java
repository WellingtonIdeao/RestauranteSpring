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
				throw new Exception("Entidade passada para inser��o � nula");

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
				throw new Exception("Entidade passada para atualiza��o � nula");
			}

			// se n�o for nula
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
				throw new Exception("Entidade passada para remo��o � nula");

			} else
				m = dao.buscarPorId(m.getId());

			// se entidade n�o estiver BD
			if (m == null)
				throw new Exception("Entidade passada para remo��o n�o encontrada");

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
				throw new Exception("Lista est� vazia");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return list;
	}

	public Mesa buscar(Mesa m) {
		try {
			// se entidade for nula
			if (m == null)
				throw new Exception("Entidade passada para busca � nula");
			else
				m = dao.buscarPorId(m.getId());

			// se entidade n�o estiver no BD
			if (m == null)
				throw new Exception(simpleName(m) + " n�o encontrado");
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
