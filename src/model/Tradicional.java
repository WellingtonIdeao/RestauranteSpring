package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Tradicional extends Pedido {

	@ManyToOne
	private Mesa mesa;

	@ManyToOne
	private Funcionario funcionario;

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

//	@Override
//	public String toString() {
//		return "Id: " + getId() + " Data: " + getData() + " Total: R$ " + getPrecoPedido() + " Status: " + getStatus()
//				+ " Cliente: " + this.mesa.getDescricao() + "(" + this.mesa.getId() + ") Atendido: " + null + " Tipo: "
//				+ getClass().getSimpleName() + this.getItens()+"\n";
//
//	}

}
