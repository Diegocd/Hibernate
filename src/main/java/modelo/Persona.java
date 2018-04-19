package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_PER")
public class Persona extends Usuario{

	@Column(name = "PER_NOM", nullable = false, length = 50)
	private String nombre;

	@Column(name = "PER_APE", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "PER_DNI", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "PER_EDA", nullable = false)
	
	private Integer edad;

	@Column(name = "PER_ECV", nullable = false)
	@Enumerated
	private EstadoCivil estadoCivil;

	public Persona() {
	}

	public Integer getEdad() {
		return edad;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

}
