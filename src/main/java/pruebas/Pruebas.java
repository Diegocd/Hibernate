package pruebas;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import modelo.EstadoCivil;
import modelo.Persona;
import modelo.TipoVehiculo;
import modelo.Vehiculo;
import repositorioPersona.RepositorioPersona;
import repositorioPersona.RepositorioVehiculo;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println(crearPersona());
		System.out.println(crearVehiculo());
		 modificarPersona();
		 modificarPersonaAlCompleto();
		 //eliminarPersona(1);
		 modificarColorDeVehiculo();
		 modificarVehiculoAlCompleto();
		 eliminarVehiculo(2);
		consultarPersona(1);
		consultarPersona("%Diego%", "", "", null);
	}

	private static Integer crearPersona() {
		Persona persona = new Persona();
		persona.setApellidos("Cruz");
		persona.setDni("12312312D");
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setNombre("Diego");
		return RepositorioPersona.crearPersona(persona);
	}

	private static void modificarPersona() {
		RepositorioPersona.modificarPersona(1, "Jesús");
	}

	private static void modificarPersonaAlCompleto() {
		Persona persona = new Persona();
		persona.setApellidos("Díaz");
		persona.setDni("12312312D");
		persona.setEdad(29);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setNombre("Miguel");
		persona.setIdPersona(1);
		RepositorioPersona.modificarPersona(persona);
	}

	public static void eliminarPersona(Integer id) {
		RepositorioPersona.eliminarPersona(id);
	}

	private static Integer crearVehiculo() {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setAnioFabricacion(new Date(15 / 01 / 1998));
		vehiculo.setColor("Azul");
		vehiculo.setMarca("Renault");
		vehiculo.setMatricula("555AAAA");
		vehiculo.setModelo("Clio");
		vehiculo.setTipoVehiculo(TipoVehiculo.COCHE);
		return RepositorioVehiculo.crearVehiculo(vehiculo);
	}

	private static void modificarColorDeVehiculo() {
		RepositorioVehiculo.modificarColorDeVehiculo(2, "Verde");
	}

	private static void modificarVehiculoAlCompleto() {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setAnioFabricacion(new Date(15 / 01 / 2002));
		vehiculo.setColor("Verde");
		vehiculo.setMarca("Renault");
		vehiculo.setMatricula("666AAAA");
		vehiculo.setModelo("Clio");
		vehiculo.setTipoVehiculo(TipoVehiculo.AVION);
		vehiculo.setIdVehiculo(2);
		RepositorioVehiculo.modificarVehiculo(vehiculo);
	}

	public static void eliminarVehiculo(Integer id) {
		RepositorioVehiculo.eliminarVehiculo(id);
	}

	private static void consultarPersona(final Integer idPersona) {
		final Persona persona = RepositorioPersona.consultarNombreCompleto(idPersona);
		System.out.println(persona.getNombre());
		System.out.println(persona.getApellidos());
		System.out.println(persona.getEstadoCivil());
		System.out.println(persona.getEdad());
		System.out.println(persona.getDni());
	}

	private static void consultarPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil) {
		final List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil);
		
		System.out.println(personas.size());
	}
}
