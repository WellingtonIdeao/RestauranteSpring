package model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "AbsDesc_id",sequenceName= "AbsDesc_seq",allocationSize = 1)
public abstract class AbstractDesconto implements Desconto, EntityGeneric {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AbsDesc_id")
	@Column(name = "AbsDesc_id")
	private long id;
	
	protected BigDecimal valor;
	
	
	@Override
	public long getId() {
		return id;
	}
	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public void setValor(BigDecimal bigDecimal) {
		this.valor = bigDecimal;
	}
	
	
	
	
	
}
