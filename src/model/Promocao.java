package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "promoc_id", sequenceName = "promoc_seq", allocationSize = 1)
public class Promocao implements Observable, EntityGeneric {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promoc_id")
	@Column(name = "promoc_id")
	private long id;
	private String descricao;

	@OneToMany(mappedBy = "promocao", fetch = FetchType.EAGER)
	private List<Cardapio> cardapios;

	private boolean changed;
	private BigDecimal valor;

	public Promocao() {
		this.cardapios = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		if (o instanceof Cardapio)
			this.cardapios.add((Cardapio) o);

	}

	@Override
	public boolean removeObserver(Observer o) {

		if (o instanceof Cardapio) {
			int pos = this.cardapios.indexOf(o);
			if (pos >= 0) {
				this.cardapios.remove(pos);
				
				//Volta oa preço do produto como estava antes da promocao
//				BigDecimal preco = ((Cardapio) o).getPreco();
//				((Cardapio) o).setPreco(preco.add(desconto.getValor()));
				return true;
			}

		}
		return false;

	}

	@Override
	public void setChanged() {
		this.changed = true;

	}

	@Override
	public void notifyObservers() {
		if (isChanged()) {
			for (Observer o : getCardapios())
				o.update(this);
			this.changed = false;
		}
	}
	
	@Override
	public void setId(long id) {
		this.id = id;

	}

	@Override
	public long getId() {
		return this.id;
	}

	public boolean isChanged() {
		return changed;
	}

	public BigDecimal getDesconto() {
		return this.valor;
	}

	public void setDesconto(BigDecimal valor) {
		this.valor = valor;
		setChanged();
		notifyObservers();
	}

		
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Cardapio> getCardapios() {
		return cardapios;
	}

	@Override
	public String toString() {
		return getDescricao();
	}


}
