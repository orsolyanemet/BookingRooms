package ro.edu.ubb.service;

import java.util.List;

import ro.edu.ubb.common.dao.BuildingDAO;
import ro.edu.ubb.common.dao.DAOFactory;
import ro.edu.ubb.dao.DAOException;
import ro.edu.ubb.entity.Building;

/**
 * Service for building.
 * @author Nemet Orsolya, noim1553
 *
 */
public class BuildingService {
	
	private BuildingDAO buildingDAO;
	private DAOFactory daoFactory;

	public BuildingService() {
		daoFactory = DAOFactory.getInstance();
		buildingDAO = daoFactory.getBuildingDAO();
	}
	
	public Building createBuilding(Building building) {
		try {
			return buildingDAO.createBuilding(building);
		} catch (DAOException e) {
			throw new ServiceException("Insert building failed.");
		}
	}
	
	public boolean createCheck(Building building) {
		try {
			return buildingDAO.createCheck(building);
		} catch (DAOException e) {
			throw new ServiceException("Create check building failed.");
		}
	}
	
	public void updateBuilding(Building building) {
		try {
			buildingDAO.updateBuilding(building);
		} catch (DAOException e) {
			throw new ServiceException("Update building failed.");
		}
	}

	public boolean deleteBuilding(Integer idBuilding) {
		try {
			return buildingDAO.deleteBuilding(idBuilding);
		} catch (DAOException e) {
			throw new ServiceException("Delete building failed.");
		}
	}
	
	public Building findByBuildingName(String buildingName) {
		try {
			return buildingDAO.findByBuildingName(buildingName);
		} catch (DAOException e) {
			throw new ServiceException("Finding building by name failed.");
		}
	}
	
	public List<Building> getAllBuildings() {
		try {
			return buildingDAO.getAllBuildings();
		} catch (DAOException e) {
			throw new ServiceException("Getting all buildings failed.");
		}
	}
}
