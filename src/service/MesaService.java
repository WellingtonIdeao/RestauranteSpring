package service;

import dao.MesaDAO;
import model.Mesa;

public class MesaService extends AbstractService<Mesa> {

	public MesaService() {
		this.dao = new MesaDAO();
	}

	@Override
	public void inserir(Mesa m) {
		manager = fac.createEntityManager();
		try {
			dao.setManager(manager);
			
			// se a mesa for nula
			if (m == null)
				throw new Exception("Entidade passada para inserção é nula");

			dao.inserir(m);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		} finally {
			this.manager.close();
		}
	}

	@Override
	public boolean atualizar(Mesa m) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			dao.setManager(manager);

			// se entidade for nula
			if (m == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}

			// se não for nula
			dao.atualizar(m);
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
