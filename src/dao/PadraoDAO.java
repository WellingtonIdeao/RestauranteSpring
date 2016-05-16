package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.EntityGeneric;

public abstract class PadraoDAO<T extends EntityGeneric> {

	protected EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void inserir(T entity) {
		manager.persist(entity);
	}

	public T buscarPorId(Long id) {
		return manager.find(entityClass(), id);
	}
	@SuppressWarnings("unchecked")
	public List<T> listar() {
		Query consulta = manager.createQuery("select p from " + entityClass().getSimpleName() + " p");
		return consulta.getResultList();

	}

	public void atualizar(T entity) {
			manager.merge(entity);

	}

	public void remover(T entity) {
		manager.remove(entity);

	}
	
	public abstract Class<T> entityClass();
}
