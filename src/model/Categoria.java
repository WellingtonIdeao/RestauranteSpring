package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
@SequenceGenerator(name = "categ_id",sequenceName = "categ_seq",allocationSize = 1)
public class Categoria implements EntityGeneric {
	@Id
	@GeneratedValue (strategy =GenerationType.SEQUENCE, generator = "categ_id")
	@Column(name = "categ_id")
	private long id;
	private String nome;
	private boolean isAtivo;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public long getId() {
		return this.id;
	}
	
	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
