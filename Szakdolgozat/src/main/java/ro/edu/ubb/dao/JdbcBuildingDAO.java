package ro.edu.ubb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.edu.ubb.common.dao.BuildingDAO;
import ro.edu.ubb.entity.Building;
import ro.edu.ubb.util.ConnectionManager;

public class JdbcBuildingDAO implements BuildingDAO {

	private ConnectionManager connectionManager;

	public JdbcBuildingDAO() {
		connectionManager = ConnectionManager.getInstance();
	}

	@Override
	public List<Building> getAllBuildings() {
		Connection connection = connectionManager.createConnection();
		List<Building> buildings = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM building ");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Building building = new Building();
				building.setIdBuilding(resultSet.getInt("idBuilding"));
				building.setBuildingName(resultSet.getString("buildingName"));
				building.setLocation(resultSet.getString("location"));
				buildings.add(building);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while getting all buildings from database.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return buildings;
	}

	@Override
	public Building findByBuildingName(String buildingName) {
		Connection connection = connectionManager.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		Building building = new Building();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM building WHERE buildingName= ? ");
			preparedStatement.setString(1, buildingName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				building.setIdBuilding(resultSet.getInt("idBuilding"));
				building.setBuildingName(resultSet.getString("buildingName"));
				building.setLocation(resultSet.getString("location"));
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while finding building by name.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return building;
	}

	@Override
	public Building createBuilding(Building building) {
		Connection connection = connectionManager.createConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO building( buildingName, location) VALUES (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, building.getBuildingName());
			preparedStatement.setString(2, building.getLocation());
			preparedStatement.execute();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			building.setIdBuilding(resultSet.getInt(1));
			preparedStatement.close();
			resultSet.close();
			return building;

		} catch (SQLException e) {
			throw new DAOException("An error occured while inserting the building.");
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public void deleteBuilding(Integer idBuilding) {
		Connection connection = connectionManager.createConnection();
		ResultSet resultSet;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT idRoom FROM room WHERE idBuilding_fk=?");
			preparedStatement.setInt(1, idBuilding);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PreparedStatement prep = connection.prepareStatement("DELETE FROM bookroom WHERE idRoomfkey=?");
				prep.setInt(1, resultSet.getInt("idRoom"));
				prep.execute();
				prep.close();
			}
			resultSet.close();
			PreparedStatement prepStatement = connection.prepareStatement("DELETE FROM room WHERE idBuilding_fk=?");
			prepStatement.setInt(1, idBuilding);
			prepStatement.execute();
			prepStatement.close();
			preparedStatement = connection.prepareStatement("DELETE FROM building WHERE idBuilding=?");
			preparedStatement.setInt(1, idBuilding);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while deleting a building.");
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public boolean createCheck(Building building) {
		createBuilding(building);
		Building created = findByBuildingName(building.getBuildingName());
		return created != null;
	}

}
