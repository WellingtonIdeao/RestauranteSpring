package model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance (strategy =  InheritanceType.JOINED)
@SequenceGenerator(name = "user_id",sequenceName = "user_seq",allocationSize = 1)
public class Usuario implements EntityGeneric {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id")
	@Column(name = "user_id")
	private long id;
	@Embedded
	private Login login;
	private String nome;
	private String email;
	private String telefone;
	
	public Usuario(){
		this.login = new Login();
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public long getId() {
		return this.id;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(String user, String password) {
		login = new Login(user, password);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return this.login.getUsuario();
	}
	
}
