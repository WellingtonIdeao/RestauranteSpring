package model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String rua;
	private String bairro;
	private String num;
	private String cep;
	private String complemento;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	@Override
	public String toString() {
		return  "R "+this.rua+" ,Nº "+this.num+"\n"+this.bairro+"\n"+this.cep;
				
		
	}

}
