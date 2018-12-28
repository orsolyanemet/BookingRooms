package ro.edu.ubb.entity;

/**
 * Enum for the types of rooms.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public enum RoomType {
	COURSE("Course"), LABORATORY("Laboratory"), SEMINAR("Seminar");
	private final String roomTypeName;

	private RoomType(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public String getRoomType() {
		return roomTypeName;
	}

	public static RoomType valueofIgnoreCase(String roomTypeName) {
		return valueOf(roomTypeName.toUpperCase());
	}
}
