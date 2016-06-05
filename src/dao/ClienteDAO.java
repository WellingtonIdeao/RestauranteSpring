package dao;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import model.Cliente;

@Repository
public class ClienteDAO extends PadraoDAO<Cliente> {

	@Override
	public Class<Cliente> entityClass() {
		return Cliente.class;
	}
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarFiltro(Cliente filtro){
		String str = "select c from Cliente c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		
		Query query=manager.createQuery(str);   
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		return query.getResultList();
	}

}
