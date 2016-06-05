package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Delivery extends Pedido {
	private double trocoPara;
	
	@ManyToOne
	private Cliente cliente;

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTrocoPara() {
		return trocoPara;
	}

	public void setTrocoPara(double trocoPara) {
		this.trocoPara = trocoPara;
	}

	@Override
	public String toString() {
		return Delivery.class.getSimpleName();
	}
			
}
