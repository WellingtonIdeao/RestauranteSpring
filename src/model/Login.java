package model;

import javax.persistence.Embeddable;

@Embeddable
public class Login {
	private String usuario;
	private String senha;
	
	public Login(){
		
	}
	public Login (String user, String senha){
		this.setUsuario(user);
		this.setSenha(senha);
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		//senha = criptSenha(senha);
		this.senha = senha;
	}
	public String criptSenha(String senha){
		return "";
	}
	
//	@Override
//	public String toString() {
//		return getUsuario();
//	}
//	
	
	

}
