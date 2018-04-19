package repositorioPersona;

import java.util.List;

import org.hibernate.Session;

import modelo.Cliente;
import modelo.EstadoCivil;
import modelo.Persona;
import util.HibernateUtil;

public class RepositorioCliente {

	public static Integer crearCliente(final Cliente persona2) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			final Integer idPersona = (Integer) sesion.save(persona2);
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

	public static void modificarCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.saveOrUpdate(cliente);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error modificando al cliente: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static void eliminarCliente(final Integer idCliente) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();
			sesion.createQuery("Delete Usuario where USU_ID = :identificador").setParameter("identificador", idCliente)
					.executeUpdate();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error eliminando al cliente: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException();
		} finally {
			sesion.close();
		}

	}

	public static List<Cliente> consultarClientes(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Cliente Where 1=1");

			if (!nombre.isEmpty()) {
				sb.append(" and CLI_NOM2 in (select nombre from Cliente where CLI_NOM2 like :nombre)");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and CLI_APE2 like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and CLI_DNI2 = :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and CLI_ECV2 = :estadoCivil");
			}
			if (!login.isEmpty()) {
				sb.append(" and USU_LOG = :login");
			}

			final org.hibernate.query.Query<Cliente> consulta = sesion.createQuery(sb.toString());

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
