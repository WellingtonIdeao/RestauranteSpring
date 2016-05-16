package model;

import java.util.Date;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente extends Usuario {
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	
	@OneToMany(mappedBy = "cliente")
	private List<Delivery> pedidos;
	
	@Embedded
	private Endereco ende;

	public Cliente(){
		this.ende = new Endereco();
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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
	
	public List<Delivery> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Delivery> pedidos) {
		this.pedidos = pedidos;
	}

}
