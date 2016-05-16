package service;

import dao.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService extends AbstractService<Funcionario> {

	public FuncionarioService() {

		this.dao = new FuncionarioDAO();

	}

	@Override
	public void inserir(Funcionario f) {
		manager = fac.createEntityManager();

		try {

			dao.setManager(manager);

			// se o funcionario for nulo
			if (f == null)
				throw new Exception("Entidade passada para inserção é nula");

			dao.inserir(f);
			manager.getTransaction().begin();
			manager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	@Override
	public boolean atualizar(Funcionario f) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			dao.setManager(manager);

			// se entidade for nula
			if (f == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}

			// se não for nula
			dao.atualizar(f);
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
