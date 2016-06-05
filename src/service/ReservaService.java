package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ReservaDAO;
import model.Reserva;
import model.Reserva;

@Service
@Transactional
public class ReservaService extends AbstractService<Reserva> {
	
	@Autowired
	private ReservaDAO dao;
	
	public void inserir(Reserva r) {
		try {
			// se a entidade for nula
			if (r == null)
				throw new Exception("Entidade passada para inserção é nula");

			// se a reserva não possui mesa
			if (r.getMesa() == null)
				throw new Exception("Reserva sem mesa");
			dao.inserir(r);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	public boolean atualizar(Reserva r) {
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
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}
	public boolean remover(Reserva reserv) {
		boolean ret = false;
		try {

			// se entidade for nula
			if (reserv == null) {
				throw new Exception("Entidade passada para remoção é nula");

			} else
				reserv = dao.buscarPorId(reserv.getId());

			// se entidade não estiver BD
			if (reserv == null)
				throw new Exception("Entidade passada para remoção não encontrada");

			dao.remover(reserv);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}

	public List<Reserva> listar() {
		List<Reserva> list = null;
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

	public Reserva buscar(Reserva reserv) {
		try {
			// se entidade for nula
			if (reserv == null)
				throw new Exception("Entidade passada para busca é nula");
			else
				reserv = dao.buscarPorId(reserv.getId());

			// se entidade não estiver no BD
			if (reserv == null)
				throw new Exception(simpleName(reserv) + " não encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return reserv;
	}

	public String simpleName(Reserva reserv) {
		return reserv.getClass().getSimpleName();

	}
	public List<Reserva> buscarFiltro(Reserva filtro){
		return  dao.buscarFiltro(filtro);
	}


}
