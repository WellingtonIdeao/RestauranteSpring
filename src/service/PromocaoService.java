package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.ProdutoDAO;
import model.Produto;
import model.Promocao;

@Service
@Transactional
public class PromocaoService extends AbstractService<Promocao> {
	@Autowired
	private ProdutoDAO prodao;
	
	@Override
	public void inserir(Promocao pr) {
		manager = fac.createEntityManager();

		try {
			// se a promocão for nula
			if (pr == null)
				throw new Exception("Entidade passada para inserção é nula");
			
			if(!pr.getCardapios().isEmpty()){
				for(Produto c:pr.getCardapios()){
					prodao.atualizar(c);
				}
			}
			
			dao.inserir(pr);
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
	public boolean atualizar(Promocao pr) {
		manager = fac.createEntityManager();
		boolean ret = false;
		try {
			// se entidade for nula
			if (pr == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}
			//se existir cardapios na promocao
			if(!pr.getCardapios().isEmpty()){
				for(Produto p: pr.getCardapios())
					prodao.atualizar(p);
			}	
			dao.atualizar(pr);
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
