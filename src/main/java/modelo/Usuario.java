package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name="A_USU")
@Inheritance(strategy =  InheritanceType.JOINED)
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="USU_ID")
	private int idUsuario;
	
	@Column(name="USU_LOG", nullable = false, unique = true)
	private String login;
	
	@Column(name="USU_PAS", nullable = false)
	private String pass;
	
	@Column(name="USU_FEC", nullable = false)
	private Date alta;
	
	public Usuario() {}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

}
