package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ClienteDAO;
import model.Cliente;

@Service
@Transactional
public class ClienteService extends AbstractService<Cliente> {

	@Autowired
	private ClienteDAO dao;
	@Autowired
	private UsuarioService userServ;
	
	public void inserir(Cliente c) throws Exception{
		try {
			// se o cliente for nula
			if (c == null)
				throw new Exception("Entidade passada para inser��o � nula");			
			if(userServ.exist(c))
				new Exception();
			else{
				dao.inserir(c);
			}
		} catch (Exception e) {
			throw new Exception();
		}

	}

	public boolean atualizar(Cliente c) {
		boolean ret = false;
		try {

			// se entidade for nula
			if (c == null) {
				throw new Exception("Entidade passada para atualiza��o � nula");
			}
			dao.atualizar(c);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} 
		return ret;
	}
	
	public boolean remover(Cliente c) {
		boolean ret = false;
		try {

			// se entidade for nula
			if (c == null) {
				throw new Exception("Entidade passada para remo��o � nula");

			} else
				c = dao.buscarPorId(c.getId());

			// se entidade n�o estiver BD
			if (c == null)
				throw new Exception("Entidade passada para remo��o n�o encontrada");

			dao.remover(c);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}

	public List<Cliente> listar() {
		List<Cliente> list = null;
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

	public Cliente buscar(Cliente c) {
		try {
			// se entidade for nula
			if (c == null)
				throw new Exception("Entidade passada para busca � nula");
			else
				c = dao.buscarPorId(c.getId());

			// se entidade n�o estiver no BD
			if (c == null)
				throw new Exception(simpleName(c) + " n�o encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}

	public String simpleName(Cliente c) {
		return c.getClass().getSimpleName();

	}
	public List<Cliente> buscarFiltro(Cliente filtro){
		return  dao.buscarFiltro(filtro);
	}


}
