package dao;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Categoria;
import model.Promocao;

@Repository
public class PromocaoDAO extends PadraoDAO<Promocao> {

	@Override
	public Class<Promocao> entityClass() {
		return Promocao.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Promocao> buscarFiltro(Promocao filtro){
		String str = "select c from Promocao c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		
		Query query=manager.createQuery(str);   
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		return query.getResultList();
	}

}
