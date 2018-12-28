package ro.edu.ubb.common.dao;

import java.util.List;

import ro.edu.ubb.entity.Building;

/**
 * DAO interface for building.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public interface BuildingDAO {
	List<Building> getAllBuildings();

	Building findByBuildingName(String buildingName);

	Building createBuilding(Building building);

	void updateBuilding(Building building);

	boolean deleteBuilding(Integer idBuilding);

	boolean createCheck(Building building);
}
