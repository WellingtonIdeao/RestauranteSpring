package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "mesa_id", sequenceName = "mesa_seq", allocationSize = 1)
public class Mesa implements EntityGeneric {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mesa_id")
	@Column(name = "mesa_id")
	private long id;
	private String descricao;
	private int capacidade;
	private boolean isReserva;
	private boolean isAtivo;

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public void setReserva(boolean isReserva) {
		this.isReserva = isReserva;
	}

	@Override
	public long getId() {
		return this.id;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getIsReserva() {
		return isReserva;
	}

	public void setIsReserva(boolean isReserva) {
		this.isReserva = isReserva;
	}

	public boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	@Override
	public String toString() {
		return getDescricao()+"("+getId()+")";
	}

}
