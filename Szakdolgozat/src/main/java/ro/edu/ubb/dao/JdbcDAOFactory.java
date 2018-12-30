package ro.edu.ubb.dao;

import ro.edu.ubb.common.dao.BuildingDAO;
import ro.edu.ubb.common.dao.CourseDAO;
import ro.edu.ubb.common.dao.DAOFactory;
import ro.edu.ubb.common.dao.UserDAO;

/**
 * Extension of DAOFactory.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public class JdbcDAOFactory extends DAOFactory{

	@Override
	public UserDAO getUserDAO() {
		return new JdbcUserDAO();
	}
	
	@Override
	public CourseDAO getCourseDAO() {
		return new JdbcCourseDAO();
	}
	
	@Override
	public BuildingDAO getBuildingDAO() {
		return new JdbcBuildingDAO();
	}

}
