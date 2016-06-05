package model;

import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario {
	
	@OneToMany(mappedBy = "cliente")
	private List<Delivery> pedidos;
	
	@Embedded
	private Endereco ende;

	public Cliente(){
		this.ende = new Endereco();
	}
	
	public Endereco getEnde() {
		return ende;
	}

	public void setEnde(String rua,String bairro, String  num, String cep, String  complemento ) {
		this.ende.setRua(rua);
		this.ende.setBairro(bairro);
		this.ende.setNum(num);
		this.ende.setCep(cep);
		this.ende.setComplemento(complemento);
	}
	
	public void setEnde(Endereco ende) {
		this.ende = ende;
	}

	public List<Delivery> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Delivery> pedidos) {
		this.pedidos = pedidos;
	}

}
