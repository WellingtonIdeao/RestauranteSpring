package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Desconto10 extends AbstractDesconto {

	
	public Desconto10(){
		BigDecimal valor1 = new BigDecimal("10");
		BigDecimal valor2 =new BigDecimal("100");
		setValor(valor1.divide(valor2));
	}	
	


}
