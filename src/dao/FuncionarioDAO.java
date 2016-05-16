package dao;


import model.Funcionario;

public class FuncionarioDAO extends PadraoDAO<Funcionario> {

	@Override
	public Class<Funcionario> entityClass() {
		return Funcionario.class;
	}

}
