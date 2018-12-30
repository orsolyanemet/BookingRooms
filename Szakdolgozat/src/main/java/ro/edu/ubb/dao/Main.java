package ro.edu.ubb.dao;

public class Main {

	public static void main(String[] args) {
		// // Test for getAllCourses
		// List<Course> courses = new ArrayList<>();
		// JdbcCourseDAO courseDAO = new JdbcCourseDAO();
		// courses = courseDAO.getAllCourses();
		// System.out.println("Let the fun begin...");
		// for (Integer i = 0; i < courses.size(); i++) {
		// System.out.println(courses.get(i).getIdCourse() + " " +
		// courses.get(i).getCourseName() + " "
		// + courses.get(i).getNrOfAttandance() + " ");
		// for (Integer j = 0; j < courses.get(i).getCourseType().size(); j++) {
		// System.out.println(courses.get(i).getCourseType().get(j).getCourseType());
		// }
		// System.out.println();
		// }

		// // Test for findCourseByName
		// JdbcCourseDAO courseDAO=new JdbcCourseDAO();
		// Course course = new Course();
		// course = courseDAO.findByCourseName("Statistics");
		// System.out
		// .println(course.getIdCourse() + " " + course.getCourseName() + " " +
		// course.getNrOfAttandance() + " ");
		// for (Integer i = 0; i < course.getCourseType().size(); i++) {
		// System.out.println(course.getCourseType().get(i).getCourseType());
		// }

//		// Test for createCourse
//		JdbcCourseDAO courseDAO = new JdbcCourseDAO();
//		Course course = new Course();
//		List<CourseType> courseType = new ArrayList<>();
//		courseType.add(CourseType.valueOf("LABORATORY"));
//		courseType.add(CourseType.valueOf("SEMINAR"));
//		// courseType.add(CourseType.valueOf("LABORTORY"));
//		course.setCourseName("C++");
//		course.setNrOfAttandance(130);
//		course.setCourseType(courseType);
//		if (courseDAO.createCheck(course)) {
//			System.out.println("Successfully created.");
//		} else {
//			System.out.println("You fucked up smth.");
//		}
		
		
	}

}
