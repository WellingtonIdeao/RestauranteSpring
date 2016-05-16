package service;

import dao.UsuarioDAO;
import model.Login;
import model.Usuario;

public class UsuarioService extends AbstractService<Usuario> {

	public UsuarioService() {
		this.dao = new UsuarioDAO();
	}
	@Override
	public void inserir(Usuario user) {
		manager = fac.createEntityManager();
		try {
			UsuarioDAO userDAO =  new UsuarioDAO();
			userDAO.setManager(manager);
			
			// se a categoria for nula
			if (user == null)
				throw new Exception("Entidade passada para inserção é nula");
			user = userDAO.buscarPorLoginSenha(user.getLogin());
			boolean exist = userDAO.exist(user);
			if(!exist){
				userDAO.inserir(user);
			}
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		} finally {
			manager.close();
		}


		
	}

		@Override
		public boolean atualizar(Usuario user) {
			manager = fac.createEntityManager();
			boolean ret = false;
			try {
				UsuarioDAO userDAO =  new UsuarioDAO();
				userDAO.setManager(manager);
				

				// se entidade for nula
				if (user == null) {
					throw new Exception("Entidade passada para atualização é nula");
				}
				// se não for nula
				dao.atualizar(user);
				manager.getTransaction().begin();
				manager.getTransaction().commit();
				ret = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				if (manager.getTransaction().isActive())
					manager.getTransaction().rollback();
			} finally {
				manager.close();
			}
			return ret;

	}
		
		public Usuario buscarLoginSenha(Login login) {
			manager = fac.createEntityManager();
			Usuario user = null;
			try {
				UsuarioDAO userDAO =  new UsuarioDAO();
				userDAO.setManager(manager);
				
				// se entidade for nula
				if (login == null)
					throw new Exception("Entidade passada para busca é nula");
				else
					user = userDAO.buscarPorLoginSenha(login);

				// se entidade não estiver no BD
				if (user == null)
					throw new Exception(simpleName(user) + " não encontrado");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				manager.close();
			}
			return user;

		}
		
		public boolean exist(Usuario user){
			manager = fac.createEntityManager();
			boolean exist = false;
			try {
				UsuarioDAO userDAO =  new UsuarioDAO();
				userDAO.setManager(manager);
				
				// se entidade for nula
				if (user == null)
					throw new Exception("Entidade passada para busca é nula");
				else
					exist = userDAO.exist(user);					
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				manager.close();
			}
			return exist;
 
		}
}
