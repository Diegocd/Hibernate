package repositorioPersona;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import modelo.Cliente;
import modelo.DetallePersona;
import modelo.Direccion;
import modelo.EstadoCivil;
import modelo.Persona;
import modelo.Telefono;
import modelo.Usuario;
import util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			final Integer idPersona = (Integer) sesion.save(persona);
			DetallePersona detalle = new DetallePersona();
			detalle.setPersona(persona);
			sesion.save(detalle);
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

	public static void agregarTelefono(final String telefono, Integer idPersona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();

			Persona persona = (Persona) sesion.createQuery("from Persona p where p.idUsuario = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();

			Telefono tlf = new Telefono();
			tlf.setNumero(telefono);
			persona.addPhone(tlf);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error agregando el telefono: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static void eliminarTelefono(final Integer idTelefono, final Integer idPersona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			Persona persona = (Persona) sesion.createQuery("from Persona p where p.idUsuario = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();

			persona.getTelefonos().removeIf(tel -> tel.getIdTelefono() == idTelefono);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error eliminando el telefono: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static void modificarTelefono(final Integer idTelefono, final Integer idPersona, final String nuevoNumTel) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();

			Persona persona = (Persona) sesion.createQuery("from Persona p where p.idUsuario = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();

			persona.getTelefonos().stream().filter(tel -> tel.getIdTelefono() == idTelefono).findFirst().get()
					.setNumero(nuevoNumTel);

			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error modificando el telefono: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static void modificarPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.saveOrUpdate(persona);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error modificando a la persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static void eliminarPersona(final Integer idPersona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			// sesion.createQuery("Delete Usuario where USU_ID =
			// :identificador").setParameter("identificador", idPersona)
			// .executeUpdate();
			sesion.delete((Usuario) sesion.createQuery("From Usuario u where u.idUsuario = :identificador")
					.setParameter("identificador", idPersona).uniqueResult());
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error eliminando a la persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static Persona consultarPersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			Persona persona = (Persona) sesion.createQuery("from Persona p where p.idUsuario = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();
			if (persona == null) {
				System.out.println("Esa persona no existe");
			}
			return persona;
		} catch (Exception e) {
			System.out.println("Se ha prducido un error con la consulta: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Persona Where 1=1");

			if (!nombre.isEmpty()) {
				sb.append(" and PER_NOM in (select nombre from Persona where PER_NOM like :nombre)");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and PER_APE like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and PER_DNI = :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and PER_ECV = :estadoCivil");
			}
			if (!login.isEmpty()) {
				sb.append(" and USU_LOG = :login");
			}

			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());

			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}
			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}
			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}
			if (estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil.ordinal());
			}
			if (!login.isEmpty()) {
				consulta.setParameter("login", login);
			}
			return consulta.list();
		} catch (Exception e) {
			System.out.println("Se ha prducido un error con la consulta: " + e.getMessage());
			sesion.getTransaction();
			throw new RuntimeException(e);
		} finally {
			sesion.close();
		}
	}

}
