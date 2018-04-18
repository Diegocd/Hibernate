package pruebas;

import modelo.EstadoCivil;
import modelo.Persona;
import repositorioPersona.RepositorioPersona;

public class Pruebas {
	
	public static void main(String[] args) {
		System.out.println(crearPersona());
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

}
