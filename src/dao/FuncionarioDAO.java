package dao;
import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import model.Funcionario;

@Repository
public class FuncionarioDAO extends PadraoDAO<Funcionario> {

	@Override
	public Class<Funcionario> entityClass() {
		return Funcionario.class;
	}
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarFiltro(Funcionario filtro){
		String str = "select c from Funcionario c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		
		Query query=manager.createQuery(str);   
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		return query.getResultList();
	}

}
