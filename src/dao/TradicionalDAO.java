package dao;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Pedido;
import model.Status;
import model.Tradicional;

@Repository
public class TradicionalDAO extends PadraoDAO<Tradicional> {

	@Override
	public Class<Tradicional> entityClass() {
		return Tradicional.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> buscarFiltro(Pedido filtro){
		StringBuilder strBuild = new StringBuilder("select c from Tradicional c ");
		if(filtro.getId()>=0)
			strBuild.append("where c.id=:ident");
		if(filtro.getTipo()!=null && filtro.getTipo()!="TODOS"){
			strBuild.append(" and c.tipo = :tipo");
		}
		if(filtro.getStatus()!=null && filtro.getStatus()!=Status.TODOS) // != TODOS NÃO LEVA EM CONSIDERAÇÃO STATUS
			strBuild.append(" and c.status = :status");
		
		String str = strBuild.toString();
		Query query= manager.createQuery(str);   
		
		query.setParameter("ident",filtro.getId());
		
		if(filtro.getTipo()!=null && filtro.getTipo()!="TODOS")
			query.setParameter("tipo",filtro.getTipo());
		if(filtro.getStatus()!=null && filtro.getStatus()!=Status.TODOS)	
			query.setParameter("status",filtro.getStatus());
		
		return query.getResultList();
	}


}
