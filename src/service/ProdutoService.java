package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.ProdutoDAO;
import model.Produto;

@Service
@Transactional
public class ProdutoService extends AbstractService<Produto> {

	@Override
	public void inserir(Produto p) {
		manager = fac.createEntityManager();
		try {
			// se o produto for nulo
			if (p == null)
				throw new Exception("Entidade passada para inserção é nula");

			// se o produto não possui categoria
			if (p.getCategoria() == null) {
				throw new Exception("Produto Sem categoria");
			}
			dao.inserir(p);
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

	public boolean atualizar(Produto p) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			// se entidade for nula
			if (p == null)
				throw new Exception("Entidade passada para atualização é nula");

			// se entidade não tiver cardapio
			if (p.getCategoria() == null)
				throw new Exception("Produto Sem categoria");

			dao.atualizar(p);
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
