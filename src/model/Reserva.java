package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@SequenceGenerator(name = "reserv_id",sequenceName = "reserv_seq", allocationSize = 1)
public class Reserva implements EntityGeneric {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE , generator = "reserv_id")
	@Column(name = "reserv_id")
	private long id;
	private int numPessoas;
	private String responsavel;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horarioInicial;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horarioFinal;
	
	@ManyToOne
	private Mesa mesa;
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public Date getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(Date horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public Date getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(Date horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public int getNumPessoas() {
		return numPessoas;
	}

	public void setNumPessoas(int numPessoas) {
		this.numPessoas = numPessoas;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public String toString() {
		return "Data Inicio: "+getHorarioInicial()+" Data Fim: "+getHorarioFinal()+mesa+
				" Responsavel: "+getResponsavel()+"\n";
	}

}
