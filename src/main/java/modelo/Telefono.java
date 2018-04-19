package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;
@Entity(name = "TEL")
public class Telefono {

	@Id
	@GeneratedValue
	@Column(name = "TEL_ID")
	private Integer idTelefono;

	@NaturalId
	@Column(name = "TEL_NUM", unique = true, nullable = false)
	private String numero;

	@ManyToOne
	private Persona personas;

	public Telefono() {
	    }

	public Integer getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return personas;
	}

	public void setPersona(Persona persona) {
		this.personas = persona;
	}

}
