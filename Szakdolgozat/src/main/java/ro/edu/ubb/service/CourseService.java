package ro.edu.ubb.service;

import java.util.List;

import ro.edu.ubb.common.dao.CourseDAO;
import ro.edu.ubb.common.dao.DAOFactory;
import ro.edu.ubb.dao.DAOException;
import ro.edu.ubb.entity.Course;

/**
 * Service for course.
 * @author Nemet Orsolya, noim1553
 *
 */
public class CourseService {

	private CourseDAO courseDAO;
	private DAOFactory daoFactory;

	public CourseService() {
		daoFactory = DAOFactory.getInstance();
		courseDAO = daoFactory.getCourseDAO();
	}
	
	public Course createCourse(Course course) {
		try {
			return courseDAO.createCourse(course);
		} catch (DAOException e) {
			throw new ServiceException("Insert course failed.");
		}
	}
	
	public boolean createCheck(Course course) {
		try {
			return courseDAO.createCheck(course);
		} catch (DAOException e) {
			throw new ServiceException("Create check course failed.");
		}
	}
	
	public void updateCourse(Course course) {
		try {
			courseDAO.updateCourse(course);
		} catch (DAOException e) {
			throw new ServiceException("Update course failed.");
		}
	}

	public void deleteCourse(Integer idCourse) {
		try {
			courseDAO.deleteCourse(idCourse);
		} catch (DAOException e) {
			throw new ServiceException("Delete course failed.");
		}
	}
	
	public Course findByCourseName(String courseName) {
		try {
			return courseDAO.findByCourseName(courseName);
		} catch (DAOException e) {
			throw new ServiceException("Finding course by name failed.");
		}
	}
	
	public List<Course> getAllCourses() {
		try {
			return courseDAO.getAllCourses();
		} catch (DAOException e) {
			throw new ServiceException("Getting all courses failed.");
		}
	}
	
}
