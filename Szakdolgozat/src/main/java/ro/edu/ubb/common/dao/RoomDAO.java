package ro.edu.ubb.common.dao;

import java.util.List;

import ro.edu.ubb.entity.Building;
import ro.edu.ubb.entity.Room;
import ro.edu.ubb.entity.RoomTypes;

/**
 * DAO interface for room.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public interface RoomDAO {
	List<Room> getAllRooms();

	Room findByRoomName(String roomName);

	Room findByRoomType(RoomTypes roomType);

	Room findByBuilding(Building building);

	Room findBySpaceCapacity(Integer spaceCapacity);

	Room createRoom(Room room);

	void updateRoom(Room room);

	boolean deleteRoom(Integer idRoom);

	boolean createCheck(Room room);
}
