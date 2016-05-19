package dao;
import org.springframework.stereotype.Repository;
import model.Funcionario;

@Repository
public class FuncionarioDAO extends PadraoDAO<Funcionario> {

	@Override
	public Class<Funcionario> entityClass() {
		return Funcionario.class;
	}

}
