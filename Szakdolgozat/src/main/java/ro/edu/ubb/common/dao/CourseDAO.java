package ro.edu.ubb.common.dao;

import java.util.List;

import ro.edu.ubb.entity.Course;

/**
 * DAO interface for course.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public interface CourseDAO {
	List<Course> getAllCourses();

	Course findByCourseName(String courseName);

	Course createCourse(Course course);

	void updateCourse(Course course);

	void deleteCourse(Integer idCourse);

	boolean createCheck(Course course);
}
