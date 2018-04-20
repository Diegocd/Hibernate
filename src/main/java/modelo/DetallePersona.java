package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="DET_PER")
public class DetallePersona {
	
	@Id
    @GeneratedValue
    @Column(name = "DET_ID")
    private Integer id;
	
	@Column(name = "DET_HIJ")
	private boolean hijos;
	
	@Column(name = "DET_DEP")
	private boolean deporte;
	
	@Column(name = "DET_MAS")
	private boolean mascotas;
	
	@OneToOne
	@JoinColumn(name = "PER_ID")
	private Persona persona;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public DetallePersona() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isHijos() {
		return hijos;
	}

	public void setHijos(boolean hijos) {
		this.hijos = hijos;
	}

	public boolean isDeporte() {
		return deporte;
	}

	public void setDeporte(boolean deporte) {
		this.deporte = deporte;
	}

	public boolean isMascotas() {
		return mascotas;
	}

	public void setMascotas(boolean mascotas) {
		this.mascotas = mascotas;
	}
	
	

}
