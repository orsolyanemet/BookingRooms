package ro.edu.ubb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.edu.ubb.common.dao.UserDAO;
import ro.edu.ubb.entity.Course;
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

	private ConnectionManager connectionManager;
	private static final String FIRSTNAME = "firstname";
	private static final String LASTNAME = "lastname";
	private static final String ROLETYPE = "roletype";
	private static final String COURSENAME = "courseName";
	private static final String IDUSER = "idUser";
	private static final String SELECT_COURSENAME="SELECT courseName FROM course WHERE idCourse=?";
	private static final String SELECT_IDCOURSE_FK="SELECT idCourse_fk FROM user_course WHERE idUser_fk=? ";
	private static final String PDUSER="pdUser";
	private static final String IDCOURSE_FK="idCourse_fk";
	
	public JdbcUserDAO() {
		connectionManager = ConnectionManager.getInstance();
	}

	@Override
	public List<User> getAllUsers() {
		Connection connection = connectionManager.createConnection();
		List<User> users = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection
					.prepareStatement("SELECT * FROM user WHERE roleType NOT LIKE \"ADMINISTRATOR\" ORDER BY username");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				List<Course> course = new ArrayList<>();
				user.setIdUser(resultSet.getInt(IDUSER));
				user.setFirstName(resultSet.getString(FIRSTNAME));
				user.setLastName(resultSet.getString(LASTNAME));
				user.setEmail(resultSet.getString("email"));
				user.setUsername(resultSet.getString("username"));
				user.setPdUser(resultSet.getString(PDUSER));
				user.setRoleType(RoleType.valueOf(resultSet.getString(ROLETYPE)));
				PreparedStatement preparedState = connection
						.prepareStatement(SELECT_IDCOURSE_FK);
				preparedState.setInt(1, resultSet.getInt(IDUSER));
				ResultSet result = preparedState.executeQuery();
				while (result.next()) {
					PreparedStatement prepared = connection
							.prepareStatement(SELECT_COURSENAME);
					prepared.setInt(1, result.getInt(IDCOURSE_FK));
					ResultSet result2 = prepared.executeQuery();
					while (result2.next()) {
						JdbcCourseDAO courseDAO = new JdbcCourseDAO();
						course.add(courseDAO.findByCourseName(result2.getString(COURSENAME)));
						user.setCourses(course);
					}
					prepared.close();
					result2.close();
				}
				preparedState.close();
				result.close();
				users.add(user);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while getting all users from database.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return users;
	}

	@Override
	public User findByUsername(String username) {
		Connection connection = connectionManager.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		User user = new User();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username= ? ");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user.setIdUser(resultSet.getInt(IDUSER));
				user.setFirstName(resultSet.getString(FIRSTNAME));
				user.setLastName(resultSet.getString(LASTNAME));
				user.setEmail(resultSet.getString("email"));
				user.setUsername(username);
				user.setPdUser(resultSet.getString(PDUSER));
				user.setRoleType(RoleType.valueOf(resultSet.getString(ROLETYPE)));
				List<Course> course = new ArrayList<>();
				PreparedStatement preparedState = connection
						.prepareStatement(SELECT_IDCOURSE_FK);
				preparedState.setInt(1, resultSet.getInt(IDUSER));
				ResultSet result = preparedState.executeQuery();
				while (result.next()) {
					PreparedStatement prepared = connection
							.prepareStatement(SELECT_COURSENAME);
					prepared.setInt(1, result.getInt(IDCOURSE_FK));
					ResultSet result2 = prepared.executeQuery();
					while (result2.next()) {
						JdbcCourseDAO courseDAO = new JdbcCourseDAO();
						course.add(courseDAO.findByCourseName(result2.getString(COURSENAME)));
						user.setCourses(course);
					}
					prepared.close();
					result2.close();
				}
				preparedState.close();
				result.close();
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while finding user by username.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		Connection connection = connectionManager.createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;
		User user = new User();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE email= ? ");
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user.setIdUser(resultSet.getInt(IDUSER));
				user.setFirstName(resultSet.getString(FIRSTNAME));
				user.setLastName(resultSet.getString(LASTNAME));
				user.setEmail(email);
				user.setUsername(resultSet.getString("username"));
				user.setPdUser(resultSet.getString(PDUSER));
				user.setRoleType(RoleType.valueOf(resultSet.getString(ROLETYPE)));
				List<Course> course = new ArrayList<>();
				PreparedStatement preparedState = connection
						.prepareStatement(SELECT_IDCOURSE_FK);
				preparedState.setInt(1, resultSet.getInt(IDUSER));
				ResultSet result = preparedState.executeQuery();
				while (result.next()) {
					PreparedStatement prepared = connection
							.prepareStatement(SELECT_COURSENAME);
					prepared.setInt(1, result.getInt(IDCOURSE_FK));
					ResultSet result2 = prepared.executeQuery();
					while (result2.next()) {
						JdbcCourseDAO courseDAO = new JdbcCourseDAO();
						course.add(courseDAO.findByCourseName(result2.getString(COURSENAME)));
						user.setCourses(course);
					}
					prepared.close();
					result2.close();
				}
				preparedState.close();
				result.close();
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while finding user by email.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return user;
	}

	@Override
	public RoleType findUserRole(String username) {
		Connection connection = connectionManager.createConnection();
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
			connectionManager.closeConnection(connection);
		}
		return role;
	}

	@Override
	public User createUser(User user) {
		Connection connection = connectionManager.createConnection();
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
			for (Integer i = 0; i < user.getCourses().size(); i++) {
				preparedStatement = connection.prepareStatement("SELECT idCourse FROM course WHERE courseName=?");
				preparedStatement.setString(1, user.getCourses().get(i).getCourseName());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					PreparedStatement prep = connection
							.prepareStatement("INSERT INTO user_course(idUser_fk,idCourse_fk) VALUES(?,?) ");
					prep.setInt(1, user.getIdUser());
					prep.setInt(2, resultSet.getInt("idCourse"));
					prep.execute();
					prep.close();
				}
				resultSet.close();
				preparedStatement.close();
			}
		} catch (SQLException e) {
			throw new DAOException("An error occured while inserting the user.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return user;
	}

	@Override
	public boolean createCheck(User user) {
		createUser(user);
		User created = findByUsername(user.getUsername());
		return created != null;
	}

	@Override
	public void updateUser(User user) {
		//TODO Update the user_course table
		Connection connection = connectionManager.createConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE user SET lastName=?, email=? where username = ?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getLastName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while updating user.");
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public void deleteUser(Integer idUser) {
		Connection connection = connectionManager.createConnection();
		try {
			PreparedStatement preparedStatement =  connection.prepareStatement("DELETE FROM bookroom WHERE idUserfkey=?");
			preparedStatement.setInt(1, idUser);
			preparedStatement.execute();
			preparedStatement=connection.prepareStatement("DELETE FROM user_course WHERE idUser_fk = ? ");
			preparedStatement.setInt(1, idUser);
			preparedStatement.execute();
			preparedStatement=connection.prepareStatement("DELETE FROM user WHERE idUser = ? ");
			preparedStatement.setInt(1, idUser);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while deleting a user.");
		} finally {
			connectionManager.closeConnection(connection);
		}
	}

	@Override
	public boolean validateUser(User user) {
		Connection connection = connectionManager.createConnection();
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
			connectionManager.closeConnection(connection);
		}
		return result;
	}

}
