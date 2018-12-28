package ro.edu.ubb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for room table.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
@Entity
@Table(name = "room")
public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372013888247874559L;

	@Id
	@Column(name = "idRoom")
	private Integer idRoom;
	@Column(name = "roomName")
	private String roomName;
	@Column(name = "spaceCapacity")
	private Integer spaceCapacity;
	@Column(name = "idBuilding_fk")
	private Building building;
	@Column(name = "idRoomType_fk")
	private RoomTypes roomType;

	public Room() {
		super();
	}

	public Room(Integer idRoom, String roomName, Integer spaceCapacity, Building building, RoomTypes roomType) {
		super();
		this.idRoom = idRoom;
		this.roomName = roomName;
		this.spaceCapacity = spaceCapacity;
		this.building = building;
		this.roomType = roomType;
	}

	public Integer getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(Integer idRoom) {
		this.idRoom = idRoom;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getSpaceCapacity() {
		return spaceCapacity;
	}

	public void setSpaceCapacity(Integer spaceCapacity) {
		this.spaceCapacity = spaceCapacity;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public RoomTypes getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypes roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "Room [idRoom=" + idRoom + ", roomName=" + roomName + ", spaceCapacity=" + spaceCapacity + ", building="
				+ building + ", roomType=" + roomType + "]";
	}
}