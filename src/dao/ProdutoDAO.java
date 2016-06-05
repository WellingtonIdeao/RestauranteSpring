package dao;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import model.Produto;

@Repository
public class ProdutoDAO extends PadraoDAO<Produto> {

	@Override
	public Class<Produto> entityClass() {
		return Produto.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscarFiltro(Produto filtro){
		StringBuilder strBuild = new StringBuilder("select c from Produto c where upper(nome) like upper(:nome)");
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		strBuild.append(" and c.categoria=:categoria");
		String str =  strBuild.toString();
		Query query=manager.createQuery(str);   
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		query.setParameter("categoria",filtro.getCategoria());
		
		return query.getResultList();
	}


}
