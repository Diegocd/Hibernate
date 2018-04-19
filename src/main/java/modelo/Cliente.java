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
@Table(name = "A_CLI")
public class Cliente extends Usuario{

	@Column(name = "CLI_NOM2", nullable = false, length = 50)
	private String nombre;

	@Column(name = "CLI_APE2", nullable = false, length = 250)
	private String apellidos;

	@Column(name = "CLI_DNI2", nullable = false, length = 9, unique = true)
	private String dni;

	@Column(name = "CLI_EDA2", nullable = false)
	
	private Integer edad;

	@Column(name = "CLI_ECV2", nullable = false)
	@Enumerated
	private EstadoCivil estadoCivil;

	public Cliente() {
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
