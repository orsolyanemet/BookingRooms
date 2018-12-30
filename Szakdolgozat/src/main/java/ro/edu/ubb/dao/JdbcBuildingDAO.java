package ro.edu.ubb.dao;

import java.util.List;

import ro.edu.ubb.common.dao.BuildingDAO;
import ro.edu.ubb.entity.Building;

public class JdbcBuildingDAO implements BuildingDAO{

	@Override
	public List<Building> getAllBuildings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Building findByBuildingName(String buildingName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Building createBuilding(Building building) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBuilding(Building building) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteBuilding(Integer idBuilding) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createCheck(Building building) {
		// TODO Auto-generated method stub
		return false;
	}

}
