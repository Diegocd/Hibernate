package repositorioPersona;

import org.hibernate.Session;

import modelo.Persona;
import util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			final Integer idPersona = (Integer) sesion.save(persona);
			sesion.getTransaction().commit();
			return idPersona;
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error insertando a la persona: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

}
