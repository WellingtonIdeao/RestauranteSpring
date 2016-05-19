package service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import model.Reserva;

@Service
@Transactional
public class ReservaService extends AbstractService<Reserva> {

	@Override
	public void inserir(Reserva r) {
		manager = fac.createEntityManager();
		try {
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
