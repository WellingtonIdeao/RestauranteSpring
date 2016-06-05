package dao;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import model.Mesa;

@Repository
public class MesaDAO extends PadraoDAO<Mesa> {

	@Override
	public Class<Mesa> entityClass() {
		return Mesa.class;
	}
	@SuppressWarnings("unchecked")
	public List<Mesa> buscarFiltro(Mesa filtro){
		StringBuilder strBuild = new StringBuilder("select c from Mesa c where upper(descricao) like upper(:descricao)");
		if(filtro.getDescricao()== null)
			filtro.setDescricao("");
			
		strBuild.append(" and c.isReserva=:reserva");
		
		String str = strBuild.toString();
		Query query=manager.createQuery(str);   
		query.setParameter("descricao", "%"+filtro.getDescricao()+"%");
		query.setParameter("reserva", filtro.getIsReserva());
		return query.getResultList();
	}

}
