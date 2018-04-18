package repositorioPersona;

import org.hibernate.Session;

import modelo.Persona;
import modelo.Vehiculo;
import util.HibernateUtil;

public class RepositorioVehiculo {
	
	public static Integer crearVehiculo(final Vehiculo vehiculo) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			final Integer idVehiculo = (Integer) sesion.save(vehiculo);
			sesion.getTransaction().commit();
			return idVehiculo;
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error insertando el vehículo: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}
	
	public static void modificarColorDeVehiculo(final Integer idVehiculo, final String color) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.createQuery("Update Vehiculo set VEH_COL = :color where VEH_ID = :identificador")
					.setParameter("color", color).setParameter("identificador", idVehiculo).executeUpdate();
			// final Persona personaBBDD = (Persona) sesion.createQuery("from Persona where
			// PER_ID = :idPersona")
			// .setParameter("idPersona", idPersona).uniqueResult();
			// personaBBDD.setNombre(nombre);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error modificando a la persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static void modificarVehiculo(final Vehiculo vehiculo) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.saveOrUpdate(vehiculo);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error modificando a la persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static void eliminarVehiculo(final Integer idVehiculo) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.createQuery("Delete Vehiculo where VEH_ID = :identificador").setParameter("identificador", idVehiculo)
					.executeUpdate();
			// sesion.delete((Vehiculo) sesion.createQuery("From Vehiculo where VEH_ID =
			// :identificador").setParameter("identificador", idVehiculo).uniqueResult());
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error eliminando a la persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

}
