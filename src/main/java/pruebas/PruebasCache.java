package pruebas;

import java.util.List;

import modelo.Aficion;
import repositorioPersona.RepositorioAficiones;

public class PruebasCache {
	
	public static void main(String[] args) {
		consultarAficiones();
		
		consultarAficiones();
	}
	
	private static void consultarAficiones() {
		final List<Aficion> aficiones = RepositorioAficiones.consultarAficiones();
		
		aficiones.stream().map(Aficion::getAficion).forEach(System.out::println);
		
	}

}
