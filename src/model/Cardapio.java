package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Cardapio extends Produto {
	
	@ManyToOne
	private Promocao promocao;

	public Cardapio(Observable o){
		if(o instanceof Promocao){
			this.promocao = (Promocao) o;
			this.promocao.registerObserver(this);
		}
	}
	public Cardapio(){
		
	}
	
	public Promocao getPromocao() {
		return promocao;
	}
	
	public void setPromocao(Observable o) {
		if(o instanceof Promocao){
			this.promocao = (Promocao) o;
			this.promocao.registerObserver(this);
			// deve fazer um merge de Promoção
		}
	}
	
	@Override
	public void update(Observable o) {
		if(o instanceof Promocao){
			BigDecimal desconto = ((Promocao) o).getDesconto();
			//				 
			//	precoAtual-	desconto = 	(precoAtual*PerDesconto/100)
			setPreco(getPreco().subtract(getPreco().multiply(desconto.divide(new BigDecimal("100")))));
		}
		
	}	
	
	
	
}
