package dao;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

import model.Reserva;

@Repository
public class ReservaDAO extends PadraoDAO<Reserva> {

	@Override
	public Class<Reserva> entityClass() {
		return Reserva.class;
	}
	@SuppressWarnings("unchecked")
	public List<Reserva> buscarFiltro(Reserva filtro){
		StringBuilder str = new StringBuilder("select c from Reserva c JOIN c.mesa m where upper(c.responsavel) like upper(:responsavel)");
		if(filtro.getResponsavel() == null){
			filtro.setResponsavel("");
		}
		 
		if(filtro.getHorarioInicial()!=null && filtro.getHorarioFinal()!=null){
			str.append(" and c.horarioInicial =:horarioInicial and c.horarioFinal = :horarioFinal");
			
		}else{
			if(filtro.getHorarioInicial()!=null)
				str.append(" and c.horarioInicial = :horarioInicial");
			if(filtro.getHorarioFinal()!=null)
				str.append(" and c.horarioFinal = :horarioFinal");
		}
		if(filtro.getMesa()!=null && filtro.getId()!=0)
			str.append(" and m.id = :mesa");
		
		String strfinal = str.toString();
		Query query=manager.createQuery(strfinal);
		
		query.setParameter("responsavel", "%"+filtro.getResponsavel()+"%");
		if(filtro.getHorarioInicial()!=null)
			query.setParameter("horarioInicial",filtro.getHorarioInicial(),TemporalType.DATE);
		if(filtro.getHorarioFinal()!=null)
			query.setParameter("horarioFinal",filtro.getHorarioFinal(),TemporalType.DATE);
		if(filtro.getMesa()!=null && filtro.getId()!=0)
			query.setParameter("mesa",filtro.getMesa());
	
		return query.getResultList();
		}
	
}
