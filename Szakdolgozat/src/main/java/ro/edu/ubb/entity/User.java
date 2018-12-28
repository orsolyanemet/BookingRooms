package ro.edu.ubb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for user table.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7015322917071948804L;

	@Id
	@Column(name = "idUser")
	private Integer idUser;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "username")
	private String username;
	@Column(name = "pdUser")
	private String pdUser;
	@Column(name = "roleType")
	private RoleType roleType;
	private List<Course> courses;

	public User() {
		super();
	}

	public User(Integer idUser, String firstName, String lastName, String email, String username, String pdUser,
			RoleType roleType, List<Course> courses) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.pdUser = pdUser;
		this.roleType = roleType;
		this.courses = courses;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPdUser() {
		return pdUser;
	}

	public void setPdUser(String pdUser) {
		this.pdUser = pdUser;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", pdUser=" + pdUser + ", roleType=" + roleType + ", courses=" + courses
				+ "]";
	}
}