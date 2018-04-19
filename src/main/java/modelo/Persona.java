package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Direccion> direcciones = new ArrayList<>();
	
	@OneToMany(mappedBy = "personas", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Telefono> telefonos = new HashSet<>();

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

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
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

    public void addAddress(Direccion direccion) {
        direcciones.add( direccion );
        direccion.getPersonas().add( this );
    }

    public void removeAddress(Direccion direccion) {
    	direcciones.remove( direccion );
    	direccion.getPersonas().remove( this );
    }
    
    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void addPhone(Telefono telefono) {
        telefonos.addAll(Arrays.asList(telefono));
        telefono.setPersona( this );
    }

    public void removePhone(Telefono telefono) {
        telefonos.removeAll(Arrays.asList(telefono));
        telefono.setPersona( null );
    }

}
