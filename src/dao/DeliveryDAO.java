package dao;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Delivery;
import model.Pedido;
import model.Status;
import model.Usuario;

@Repository
public class DeliveryDAO extends PadraoDAO<Delivery> {

	@Override
	public Class<Delivery> entityClass() {
		return Delivery.class;
	}
	@SuppressWarnings("unchecked")
	public List<Pedido> buscarFiltro(Pedido filtro){
		StringBuilder strBuild = new StringBuilder("select c from Delivery c  where c.id=:ident");
		if(filtro.getTipo()!=null){
			strBuild.append(" and c.tipo = :tipo");
		}
		String str = strBuild.toString();
		Query query= manager.createQuery(str);   
		query.setParameter("ident",filtro.getId());
		query.setParameter("tipo",filtro.getTipo());
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Delivery> buscarFiltroDelivery(Delivery filtro){
		StringBuilder strBuild = new StringBuilder("select c from Delivery c where c.cliente =:cliente ");
			
		if(filtro.getId()>0){
			 strBuild.append("and c.id=:ident");	 
		}
		if(filtro.getStatus()!=null && filtro.getStatus()!=Status.TODOS) // != TODOS NÃO LEVA EM CONSIDERAÇÃO STATUS
			strBuild.append(" and c.status = :status");
		
		String str = strBuild.toString();
		Query query= manager.createQuery(str);
		
		if(filtro.getId()>0){
			query.setParameter("ident",filtro.getId());
		}
		if(filtro.getStatus()!=null && filtro.getStatus()!=Status.TODOS){	
			query.setParameter("status",filtro.getStatus());
		}
		query.setParameter("cliente",filtro.getCliente());
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Delivery> listarPorCliente(Usuario user) {
		Query consulta = manager.createQuery("select p from Delivery  p WHERE p.cliente =:cliente");
		consulta.setParameter("cliente",user);
		return consulta.getResultList();
	}

	

}
