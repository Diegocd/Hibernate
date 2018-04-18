package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEH")
public class Vehiculo {
	
	@Id
	@GeneratedValue
	@Column(name = "VEH_ID")
	private int idVehiculo;

	@Column(name = "VEH_MOD", nullable = false, length = 50)
	private String modelo;

	@Column(name = "VEH_MAR", nullable = false, length = 50)
	private String marca;
	
	@Column(name = "VEH_COL", nullable = false, length = 25)
	private String color;

	@Column(name = "VEH_MAT", nullable = false, length = 7, unique = true)
	private String matricula;

	@Column(name = "VEH_FAB", nullable = false)
	private Date anioFabricacion;

	@Column(name = "VEH_TIP", nullable = false)
	@Enumerated
	private TipoVehiculo tipoVehiculo;
	
	public Vehiculo() {
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public String getColor() {
		return color;
	}

	public String getMatricula() {
		return matricula;
	}

	public Date getAnioFabricacion() {
		return anioFabricacion;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setAnioFabricacion(Date anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

}
