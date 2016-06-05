package dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Categoria;

@Repository
public class CategoriaDAO extends PadraoDAO<Categoria> {

	@Override
	public Class<Categoria> entityClass() {
		return Categoria.class;
	}
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarFiltro(Categoria filtro){
		String str = "select c from Categoria c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		
		Query query=manager.createQuery(str);   
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		return query.getResultList();
	}

}
