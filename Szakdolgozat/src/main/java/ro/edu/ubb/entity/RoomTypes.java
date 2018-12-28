package ro.edu.ubb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for roomtype table.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
@Entity
@Table(name = "roomtype")
public class RoomTypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7736483555185199511L;

	@Id
	@Column(name = "idRoomType")
	private Integer idRoomType;
	@Column(name = "roomTypeName")
	private String roomTypeName;

	public RoomTypes() {
		super();
	}

	public RoomTypes(Integer idRoomType, String roomTypeName) {
		super();
		this.idRoomType = idRoomType;
		this.roomTypeName = roomTypeName;
	}

	public Integer getIdRoomType() {
		return idRoomType;
	}

	public void setIdRoomType(Integer idRoomType) {
		this.idRoomType = idRoomType;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	@Override
	public String toString() {
		return "RoomTypes [idRoomType=" + idRoomType + ", roomTypeName=" + roomTypeName + "]";
	}

}
