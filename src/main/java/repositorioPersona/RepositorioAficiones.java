package repositorioPersona;

import java.util.List;

import org.hibernate.Session;

import modelo.Aficion;
import modelo.Persona;
import util.HibernateUtil;

public class RepositorioAficiones {
	
	public static List<Aficion> consultarAficiones() {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			return sesion.createQuery("from Aficion").setCacheable(true).list();
		} catch (Exception e) {
			System.out.println("Se ha prducido un error con la consulta: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

}
