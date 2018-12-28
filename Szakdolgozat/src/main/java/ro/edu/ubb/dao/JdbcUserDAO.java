package ro.edu.ubb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.edu.ubb.common.dao.UserDAO;
import ro.edu.ubb.entity.RoleType;
import ro.edu.ubb.entity.User;
import ro.edu.ubb.util.ConnectionManager;
import ro.edu.ubb.util.SecureData;

/**
 * Implementation of UserDAO.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public class JdbcUserDAO implements UserDAO {

	private ConnectionManager cm;
	private static final String FIRSTNAME = "firstname";
	private static final String LASTNAME = "lastname";
	private static final String ROLETYPE = "roletype";

	public JdbcUserDAO() {
		cm = ConnectionManager.getInstance();
	}

	@Override
	public List<User> getAllUsers() {
		Connection connection = cm.createConnection();
		List<User> users = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM user WHERE roleType NOT LIKE \"ADMINISTRATOR\" ORDER BY username");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setIdUser(resultSet.getInt("idUser"));
				user.setFirstName(resultSet.getString(FIRSTNAME));
				user.setLastName(resultSet.getString(LASTNAME));
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPdUser(resultSet.getString("pdUser"));
				user.setRoleType(RoleType.valueOf(resultSet.getString(ROLETYPE)));
				users.add(user);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while getting all users from database.");
		} finally {
			cm.closeConnection(connection);
		}
		return users;
	}

	@Override
	public User findByUsername(String username) {
		Connection connection = cm.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		User user = new User();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username= ? ");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user.setFirstName(resultSet.getString(FIRSTNAME));
				user.setLastName(resultSet.getString(LASTNAME));
				user.setEmail(resultSet.getString("email"));
				user.setRoleType(RoleType.valueOf(resultSet.getString(ROLETYPE)));
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while finding user by username.");
		} finally {
			cm.closeConnection(connection);
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		Connection connection = cm.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		User user = new User();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email= ? ");
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user.setFirstName(resultSet.getString(FIRSTNAME));
				user.setLastName(resultSet.getString(LASTNAME));
				user.setUsername(resultSet.getString("username"));
				user.setRoleType(RoleType.valueOf(resultSet.getString(ROLETYPE)));
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while finding user by email.");
		} finally {
			cm.closeConnection(connection);
		}
		return user;
	}

	@Override
	public RoleType findUserRole(String username) {
		Connection connection = cm.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		RoleType role = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT roleType FROM user WHERE username= ? ");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				role = RoleType.valueOfIgnoreCase(resultSet.getString(ROLETYPE));
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while finding  user role.");
		} finally {
			cm.closeConnection(connection);
		}
		return role;
	}

	@Override
	public User createUser(User user) {
		Connection connection = cm.createConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO user( firstName, lastName, email, username, pdUser, roleType) VALUES (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, SecureData.convertHexToString(SecureData.hashPassword(user.getPdUser())));
			preparedStatement.setString(6, user.getRoleType().toString());
			preparedStatement.execute();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			user.setIdUser(resultSet.getInt(1));
			preparedStatement.close();
			resultSet.close();
			return user;

		} catch (SQLException e) {
			throw new DAOException("An error occured while inserting the user.");
		} finally {
			cm.closeConnection(connection);
		}
	}

	@Override
	public String createCheck(User user) {
		createUser(user);
		User created = findByUsername(user.getUsername());
		if (created != null) {
			return "OK";
		}
		return "NULL";

	}

	@Override
	public void updateUser(User user) {
		Connection connection = cm.createConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE user SET firstName=?, lastName=?, email=? where username = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while updating user.");
		} finally {
			cm.closeConnection(connection);
		}
	}

	@Override
	public boolean deleteUser(Integer idUser) {
		Connection connection = cm.createConnection();
		boolean result;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE idUser = ? ");
			preparedStatement.setInt(1, idUser);
			result = preparedStatement.execute();
			preparedStatement.close();
			result = true;
		} catch (SQLException e) {
			throw new DAOException("An error occured while deleting a user.");
		} finally {
			cm.closeConnection(connection);
		}
		return result;
	}

	@Override
	public boolean validateUser(User user) {
		Connection connection = cm.createConnection();
		boolean result = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM user WHERE username = ? and pdUser = ?");
			preparedStatement.setString(1, user.getUsername());
			RoleType userRole = findUserRole(user.getUsername());
			user.setRoleType(userRole);
			RoleType role = user.getRoleType();
			if (role == RoleType.ADMINISTRATOR) {
				preparedStatement.setString(2, user.getPdUser());
			} else {
				if (role == RoleType.ASSISTANT || role == RoleType.ASSOCIATE_PROFESSOR
						|| role == RoleType.DOCTORAL_STUDENT || role == RoleType.LECTURER_PROFESSOR
						|| role == RoleType.PROFESSOR) {
					preparedStatement.setString(2,
							SecureData.convertHexToString(SecureData.hashPassword(user.getPdUser())));
				} else {
					preparedStatement.setString(2, " ");
				}
			}
			ResultSet resultSet = preparedStatement.executeQuery();
			result = resultSet.next();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured during the validation of user.");
		} finally {
			cm.closeConnection(connection);
		}
		return result;
	}

}
