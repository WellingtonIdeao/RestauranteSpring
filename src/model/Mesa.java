package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
@SequenceGenerator (name = "mesa_id",sequenceName = "mesa_seq", allocationSize = 1)
public class Mesa implements EntityGeneric {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mesa_id")
	@Column(name = "mesa_id")
	private long id;
	private String descricao;
	private int capacidade;
		
	@Override
	public void setId(long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Numero: "+getId()+" Descricao: "+getDescricao()+" Capacidade: "+getCapacidade();
	}

}
