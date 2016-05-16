package service;

import dao.ProdutoDAO;
import dao.PromocaoDAO;
import model.Cardapio;
import model.Produto;
import model.Promocao;

public class PromocaoService extends AbstractService<Promocao> {

	
	public PromocaoService(){
		this.dao = new PromocaoDAO();
		
	}
	@Override
	public void inserir(Promocao pr) {
		manager = fac.createEntityManager();

		try {
			dao.setManager(manager);
			ProdutoDAO prodao = new ProdutoDAO();
			prodao.setManager(manager);
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
			dao.setManager(manager);
			ProdutoDAO Pdao = new ProdutoDAO();
			Pdao.setManager(manager);
			// se entidade for nula
			if (pr == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}
			//se existir cardapios na promocao
			if(!pr.getCardapios().isEmpty()){
				for(Produto p: pr.getCardapios())
					Pdao.atualizar(p);
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
