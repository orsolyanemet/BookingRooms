package ro.edu.ubb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.edu.ubb.common.dao.CourseDAO;
import ro.edu.ubb.entity.Course;
import ro.edu.ubb.entity.CourseType;
import ro.edu.ubb.util.ConnectionManager;

/**
 * Implementation of CourseDAO.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public class JdbcCourseDAO implements CourseDAO {

	private ConnectionManager connectionManager;

	public JdbcCourseDAO() {
		connectionManager = ConnectionManager.getInstance();
	}

	@Override
	public List<Course> getAllCourses() {
		Connection connection = connectionManager.createConnection();
		List<Course> courses = new ArrayList<>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM course");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Course course = new Course();
				List<CourseType> courseType = new ArrayList<>();
				course.setIdCourse(resultSet.getInt("idCourse"));
				course.setCourseName(resultSet.getString("courseName"));
				course.setNrOfAttandance(resultSet.getInt("nrOfAttandance"));
				PreparedStatement preparedState = connection
						.prepareStatement("SELECT idCourseType_fk FROM course_coursetype WHERE idCoursefk= ?");
				preparedState.setInt(1, resultSet.getInt("idCourse"));
				ResultSet result = preparedState.executeQuery();
				while (result.next()) {
					PreparedStatement prepared = connection
							.prepareStatement("SELECT courseTypeName FROM coursetype WHERE idCourseType=?");
					prepared.setInt(1, result.getInt("idCourseType_fk"));
					ResultSet result2 = prepared.executeQuery();
					while (result2.next()) {
						courseType.add(CourseType.valueOfIgnoreCase(result2.getString("courseTypeName")));
						course.setCourseType(courseType);
					}
					prepared.close();
					result2.close();
				}
				preparedState.close();
				result.close();
				courses.add(course);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while getting all courses from the database.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return courses;
	}

	@Override
	public Course findByCourseName(String courseName) {
		Connection connection = connectionManager.createConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Course course = new Course();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE courseName=?");
			preparedStatement.setString(1, courseName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				course.setIdCourse(resultSet.getInt("idCourse"));
				course.setCourseName(courseName);
				course.setNrOfAttandance(resultSet.getInt("nrOfAttandance"));
				List<CourseType> courseType = new ArrayList<>();
				PreparedStatement preparedState = connection
						.prepareStatement("SELECT idCourseType_fk FROM course_coursetype WHERE idCoursefk= ?");
				preparedState.setInt(1, resultSet.getInt("idCourse"));
				ResultSet result = preparedState.executeQuery();
				while (result.next()) {
					PreparedStatement prepared = connection
							.prepareStatement("SELECT courseTypeName FROM coursetype WHERE idCourseType=?");
					prepared.setInt(1, result.getInt("idCourseType_fk"));
					ResultSet result2 = prepared.executeQuery();
					while (result2.next()) {
						courseType.add(CourseType.valueOfIgnoreCase(result2.getString("courseTypeName")));
						course.setCourseType(courseType);
					}
					prepared.close();
					result2.close();
				}
				preparedState.close();
				result.close();
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			throw new DAOException("An error occured while finding course by course name.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return course;
	}

	@Override
	public Course createCourse(Course course) {
		Connection connection = connectionManager.createConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO course(courseName, nrOfAttandance) VALUES (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, course.getCourseName());
			preparedStatement.setInt(2, course.getNrOfAttandance());
			preparedStatement.execute();
			ResultSet resultSet=preparedStatement.getGeneratedKeys();
			resultSet.next();
			course.setIdCourse(resultSet.getInt(1));
			preparedStatement.close();
			resultSet.close();
			for(Integer i=0;i<course.getCourseType().size();i++) {
				preparedStatement=connection.prepareStatement("SELECT idCourseType FROM coursetype WHERE courseTypeName=?");
				preparedStatement.setString(1, course.getCourseType().get(i).getCourseType());
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					PreparedStatement prep=connection.prepareStatement("INSERT INTO course_coursetype(idCoursefk,idCourseType_fk) VALUES(?,?)");
					prep.setInt(1, course.getIdCourse());
					prep.setInt(2, resultSet.getInt("idCourseType"));
					prep.execute();
					prep.close();
				}
				resultSet.close();
				preparedStatement.close();
			}
		} catch (SQLException e) {
			throw new DAOException("An error occured while creating a course.");
		} finally {
			connectionManager.closeConnection(connection);
		}
		return course;
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Update the courseName or nrOfAttandance from course table
		// And update the course_coursetype table too

	}

	@Override
	public boolean deleteCourse(Integer idCourse) {
		// TODO Delete course BUT first we need to delete rows from other tables where the courseId appears as a foreign key
		return false;
	}

	@Override
	public boolean createCheck(Course course) {
		createCourse(course);
		Course created = findByCourseName(course.getCourseName());
		if (created != null) {
			return true;
		}
		return false;
	}

}
