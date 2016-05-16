package service;

import dao.ReservaDAO;
import model.Reserva;

public class ReservaService extends AbstractService<Reserva> {

	public ReservaService() {
		this.dao = new ReservaDAO();
	}

	@Override
	public void inserir(Reserva r) {
		manager = fac.createEntityManager();
		try {
			dao.setManager(manager);

			// se a entidade for nula
			if (r == null)
				throw new Exception("Entidade passada para inserção é nula");

			// se a reserva não possui mesa
			if (r.getMesa() == null)
				throw new Exception("Reserva sem mesa");
			dao.inserir(r);
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
	public boolean atualizar(Reserva r) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			dao.setManager(manager);

			// se reserva for nula
			if (r == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}

			// se a entidade não tiver mesa
			if (r.getMesa() == null)
				throw new Exception("Reserva sem mesa");

			dao.atualizar(r);
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
