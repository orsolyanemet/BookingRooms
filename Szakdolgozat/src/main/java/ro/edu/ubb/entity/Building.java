package ro.edu.ubb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for building table.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
@Entity
@Table(name = "user")
public class Building implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8547205803440106412L;
	@Id
	@Column(name = "idBuilding")
	private Integer idBuilding;
	@Column(name = "buildingName")
	private String buildingName;
	@Column(name = "location")
	private String location;

	public Building() {
		super();
	}

	public Building(Integer idBuilding, String buildingName, String location) {
		super();
		this.idBuilding = idBuilding;
		this.buildingName = buildingName;
		this.location = location;
	}

	public Integer getIdBuilding() {
		return idBuilding;
	}

	public void setIdBuilding(Integer idBuilding) {
		this.idBuilding = idBuilding;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Building [idBuilding=" + idBuilding + ", buildingName=" + buildingName + ", location=" + location + "]";
	}
}
