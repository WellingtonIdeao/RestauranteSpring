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
				throw new Exception("Entidade passada para inserção é nula");			
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
				throw new Exception("Entidade passada para atualização é nula");
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
				throw new Exception("Entidade passada para remoção é nula");

			} else
				c = dao.buscarPorId(c.getId());

			// se entidade não estiver BD
			if (c == null)
				throw new Exception("Entidade passada para remoção não encontrada");

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
				throw new Exception("Lista está vazia");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return list;
	}

	public Cliente buscar(Cliente c) {
		try {
			// se entidade for nula
			if (c == null)
				throw new Exception("Entidade passada para busca é nula");
			else
				c = dao.buscarPorId(c.getId());

			// se entidade não estiver no BD
			if (c == null)
				throw new Exception(simpleName(c) + " não encontrado");
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
