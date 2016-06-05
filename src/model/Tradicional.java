package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Tradicional extends Pedido {

	@ManyToOne
	private Mesa mesa;

	@ManyToOne
	private Funcionario funcionario;

	public Tradicional(){
		mesa = new  Mesa();
	}
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Long mesa) {
		this.mesa.setId(mesa);
	}
	public void setandoMesa(Mesa mesa) {
		this.mesa = mesa;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	@Override
	public String toString() {
		return Tradicional.class.getSimpleName();
	}
	

}
