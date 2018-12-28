package ro.edu.ubb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for roleType table.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
@Entity
@Table(name = "roleType")
public class RoleTypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idRoleType")
	private Integer idRoleType;
	@Column(name = "roleTypeName")
	private String roleTypeName;

	public RoleTypes() {
		super();
	}

	public RoleTypes(Integer idRoleType, String roleTypeName) {
		super();
		this.idRoleType = idRoleType;
		this.roleTypeName = roleTypeName;
	}

	public Integer getIdRoleType() {
		return idRoleType;
	}

	public void setIdRoleType(Integer idRoleType) {
		this.idRoleType = idRoleType;
	}

	public String getRoleTypeName() {
		return roleTypeName;
	}

	public void setRoleTypeName(String roleTypeName) {
		this.roleTypeName = roleTypeName;
	}

	@Override
	public String toString() {
		return "RoleTypes [idRoleType=" + idRoleType + ", roleTypeName=" + roleTypeName + "]";
	}
}