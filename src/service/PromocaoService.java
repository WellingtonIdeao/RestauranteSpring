package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.ProdutoDAO;
import dao.PromocaoDAO;
import model.Produto;
import model.Promocao;

@Service
@Transactional
public class PromocaoService extends AbstractService<Promocao> {
	
	@Autowired
	private PromocaoDAO dao;
	@Autowired
	private ProdutoDAO prodao;
	
	public void inserir(Promocao pr) {
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
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean atualizar(Promocao pro) {
		boolean ret = false;
		try {
			// se entidade for nula
			if (pro == null) {
				throw new Exception("Entidade passada para atualização é nula");
			}
			//se existir cardapios na promocao
			if(!pro.getCardapios().isEmpty()){
				for(Produto p: pro.getCardapios())
					prodao.atualizar(p);
			}	
			dao.atualizar(pro);
			ret = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}
	public List<Promocao> listar() {
		List<Promocao> list = null;
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

	public Promocao buscar(Promocao pro) {
		try {
			// se entidade for nula
			if (pro == null)
				throw new Exception("Entidade passada para busca é nula");
			else
				pro = dao.buscarPorId(pro.getId());

			// se entidade não estiver no BD
			if (pro == null)
				throw new Exception(simpleName(pro) + " não encontrado");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pro;
	}
	public boolean remover(Promocao pro) {
		boolean ret = false;
		try {

			// se entidade for nula
			if (pro == null) {
				throw new Exception("Entidade passada para remoção é nula");

			} else
				 pro = dao.buscarPorId(pro.getId());

			// se entidade não estiver BD
			if ( pro== null)
				throw new Exception("Entidade passada para remoção não encontrada");

			dao.remover(pro);
			ret = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return ret;
	}


	public String simpleName(Promocao pro) {
		return pro.getClass().getSimpleName();

	}
	public List<Promocao> buscarFiltro(Promocao filtro){
		return  dao.buscarFiltro(filtro);
	}
	
}
