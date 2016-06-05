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

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@SequenceGenerator(name = "reserv_id",sequenceName = "reserv_seq", allocationSize = 1)
public class Reserva implements EntityGeneric {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE , generator = "reserv_id")
	@Column(name = "reserv_id")
	private long id;
	private String responsavel;
		
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date horarioInicial;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date horarioFinal;
	
	@ManyToOne
	private Mesa mesa;
	
	public Reserva(){
		horarioInicial= new Date();
		horarioFinal = new Date();
		mesa = new Mesa();
		
	}
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

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Long mesa) {
		this.mesa.setId(mesa);
	}
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
}
