package ro.edu.ubb.common.dao;

import ro.edu.ubb.dao.JdbcDAOFactory;

/**
 * DAO factory abstract class.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public abstract class DAOFactory {

	public static DAOFactory getInstance() {
		return new JdbcDAOFactory();
	}

	public abstract UserDAO getUserDAO();

}
