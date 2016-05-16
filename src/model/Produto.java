package model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "prod_id",sequenceName= "prod_seq",allocationSize = 1)
public abstract class Produto implements EntityGeneric, Observer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id")
	@Column(name = "prod_id")
	private long id;
	
	private String nome;
	private BigDecimal preco;
	private boolean isAtivo;
	
	@ManyToOne
	private Categoria categoria;
	
	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public long getId() {
		return this.id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}

	
	public void setPreco(BigDecimal preco) {
		this.preco = preco ;
	}
	
	
	public BigDecimal getPreco(){
		return this.preco;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	@Override
	public boolean equals(Object obj) {
		Produto prod = (Produto)obj;
		if(prod.getId() == this.getId())
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return getNome()+"(R$ "+getPreco()+")";
	}

}
