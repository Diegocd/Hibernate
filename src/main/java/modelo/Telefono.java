package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NaturalId;

@Entity(name = "TEL")
public class Telefono {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEL_SEC")
	@SequenceGenerator(name = "TEL_SEC", sequenceName = "TEL_SEC_SEC", initialValue = 100)
	@Column(name = "TEL_ID")
	private Integer idTelefono;

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
