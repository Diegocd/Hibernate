package pruebas;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import modelo.Cliente;
import modelo.EstadoCivil;
import modelo.Persona;
import modelo.TipoVehiculo;
import modelo.Vehiculo;
import repositorioPersona.RepositorioCliente;
import repositorioPersona.RepositorioPersona;
import repositorioPersona.RepositorioVehiculo;

public class Pruebas {

	public static void main(String[] args) {
		crearPersona("11111111S", "log1");
		crearCliente("11111111D", "log2");
		crearPersona("11111111R", "log3");
		crearCliente("11111111E", "log4");
//		 modificarPersona();
		 modificarPersonaAlCompleto();
		 modificarClienteAlCompleto();
		 eliminarPersona(3);
		 eliminarCliente(4);
//		 modificarColorDeVehiculo();
//		 modificarVehiculoAlCompleto();
//		 eliminarVehiculo(2);
//		consultarPersona(1);
		consultarPersona("%Miguel%", "", "", null, "Miguel1");
		consultarCliente("%Miguel%", "", "", null, "Miguel2");
	}

	private static Integer crearPersona(String dni, String login) {
		
//		for (int i = 12345670; i<12345680; i++) {
//			Persona persona = new Persona();
//			persona.setApellidos("Cruz");
//			persona.setDni(String.valueOf(i) + "D");
//			persona.setEdad(18);
//			persona.setEstadoCivil(EstadoCivil.CASADO);
//			persona.setNombre("Diego");
//			RepositorioPersona.crearPersona(persona);
//			}
		
		Persona persona = new Persona();
		persona.setApellidos("Cruz");
		persona.setDni(dni);
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setNombre("Diego");
		persona.setAlta(new Date());
		persona.setLogin(login);
		persona.setPass("login");
		return RepositorioPersona.crearPersona(persona);
		
	}
	
private static Integer crearCliente(String dni, String login) {
		
		Cliente persona = new Cliente();
		persona.setApellidos("Cruz");
		persona.setDni(dni);
		persona.setEdad(18);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setNombre("Diego");
		persona.setAlta(new Date());
		persona.setLogin(login);
		persona.setPass("login");
		return RepositorioCliente.crearCliente(persona);
		
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
		persona.setIdUsuario(1);
		persona.setAlta(new Date(01/01/2001));
		persona.setLogin("Miguel1");
		persona.setPass("login");
		RepositorioPersona.modificarPersona(persona);
	}
	
	private static void modificarClienteAlCompleto() {
		Cliente persona = new Cliente();
		persona.setApellidos("Díaz");
		persona.setDni("22312312D");
		persona.setEdad(29);
		persona.setEstadoCivil(EstadoCivil.CASADO);
		persona.setNombre("Miguel");
		persona.setIdUsuario(2);
		persona.setAlta(new Date(01/01/2001));
		persona.setLogin("Miguel2");
		persona.setPass("login");
		RepositorioCliente.modificarCliente(persona);
	}

	public static void eliminarPersona(Integer id) {
		RepositorioPersona.eliminarPersona(id);
	}
	
	public static void eliminarCliente(Integer id) {
		RepositorioCliente.eliminarCliente(id);
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

	private static void consultarPersona(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final List<Persona> personas = RepositorioPersona.consultar(nombre, apellidos, dni, estadoCivil, login);
		
		System.out.println(personas.size());
	}
	
	private static void consultarCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final List<Cliente> clientes = RepositorioCliente.consultarClientes(nombre, apellidos, dni, estadoCivil, login);
		
		System.out.println(clientes.size());
	}
}
