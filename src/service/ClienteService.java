package service;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteService extends AbstractService<Cliente> {

	public ClienteService() {
		this.dao = new ClienteDAO();
	}

	@Override
	public void inserir(Cliente c) throws Exception{
		manager = fac.createEntityManager();

		try {
			dao.setManager(manager);
			// se o cliente for nula
			if (c == null)
				throw new Exception("Entidade passada para inserção é nula");
			UsuarioService userServ = new UsuarioService();
			
			if(userServ.exist(c))
				new Exception();
			else{
				dao.inserir(c);
				manager.getTransaction().begin();
				manager.getTransaction().commit();
			}
		} catch (Exception e) {
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			throw new Exception();
		} finally {
			manager.close();
		}

	}

	@Override
	public boolean atualizar(Cliente c) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			dao.setManager(manager);

			// se entidade for nula
			if (c == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}
			dao.atualizar(c);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
			;
		} finally {
			manager.close();
		}
		return ret;
	}

}
