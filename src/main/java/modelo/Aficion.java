package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aficion {
	
	@Id
	@GeneratedValue
	@Column(name = "AFI_ID")
	private int idAficion;
	
	@Column(name = "AFI_AFI")
	private String aficion;
	
	@ManyToMany(mappedBy = "aficiones")
	private List<Persona> personas = new ArrayList<Persona>();

	public int getIdAficion() {
		return idAficion;
	}
	
	public Aficion() {}

	public void setIdAficion(int idAficion) {
		this.idAficion = idAficion;
	}

	public String getAficion() {
		return aficion;
	}

	public void setAficion(String aficion) {
		this.aficion = aficion;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
}
