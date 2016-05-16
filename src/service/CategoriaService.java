package service;

import dao.CategoriaDAO;
import model.Categoria;

public class CategoriaService extends AbstractService<Categoria> {

	public CategoriaService() {
		this.dao = new CategoriaDAO();
	}

	@Override
	public void inserir(Categoria c) {
		manager = fac.createEntityManager();
		try {
			dao.setManager(manager);

			// se a categoria for nula
			if (c == null)
				throw new Exception("Entidade passada para inserção é nula");
			dao.inserir(c);
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
	public boolean atualizar(Categoria c) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			dao.setManager(manager);

			// se entidade for nula
			if (c == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}

			// se não for nula
			dao.atualizar(c);
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
}
