package ro.edu.ubb.dao;

public class Main {

	public static void main(String[] args) {
		// // Test for getAllCourses
		/*
		 * List<Course> courses = new ArrayList<>(); JdbcCourseDAO courseDAO = new
		 * JdbcCourseDAO(); courses = courseDAO.getAllCourses();
		 * System.out.println("Let the fun begin..."); for (Integer i = 0; i <
		 * courses.size(); i++) { System.out.println(courses.get(i).getIdCourse() + " "
		 * + courses.get(i).getCourseName() + " " + courses.get(i).getNrOfAttandance() +
		 * " "); for (Integer j = 0; j < courses.get(i).getCourseType().size(); j++) {
		 * System.out.println(courses.get(i).getCourseType().get(j).getCourseType()); }
		 * System.out.println(); }
		 * 
		 * // Test for findCourseByName JdbcCourseDAO courseDAO=new JdbcCourseDAO();
		 * Course course = new Course(); course =
		 * courseDAO.findByCourseName("Statistics"); System.out
		 * .println(course.getIdCourse() + " " + course.getCourseName() + " " +
		 * course.getNrOfAttandance() + " "); for (Integer i = 0; i <
		 * course.getCourseType().size(); i++) {
		 * System.out.println(course.getCourseType().get(i).getCourseType()); }
		 * 
		 * // Test for createCourse JdbcCourseDAO courseDAO = new JdbcCourseDAO();
		 * Course course = new Course(); List<CourseType> courseType = new
		 * ArrayList<>(); courseType.add(CourseType.valueOf("LABORATORY"));
		 * courseType.add(CourseType.valueOf("SEMINAR")); //
		 * courseType.add(CourseType.valueOf("LABORTORY")); course.setCourseName("C++");
		 * course.setNrOfAttandance(130); course.setCourseType(courseType); if
		 * (courseDAO.createCheck(course)) {
		 * System.out.println("Successfully created."); } else {
		 * System.out.println("You fucked up smth."); }
		 * 
		 * //Test for getAllBuildings List<Building> buildings = new ArrayList<>();
		 * JdbcBuildingDAO buildingDAO = new JdbcBuildingDAO(); buildings =
		 * buildingDAO.getAllBuildings(); System.out.println("Let the fun begin...");
		 * for (Integer i = 0; i < buildings.size(); i++) {
		 * System.out.println(buildings.get(i).getIdBuilding() + " " +
		 * buildings.get(i).getBuildingName() + " " + buildings.get(i).getLocation() +
		 * " "); }
		 * 
		 * // Test for findBuildingByName JdbcBuildingDAO buildingDAO=new
		 * JdbcBuildingDAO(); Building building = new Building(); building =
		 * buildingDAO.findByBuildingName("Faculty of Mathematics and Computer
		 * Science"); System.out.println(building.getIdBuilding() + " " +
		 * building.getBuildingName() + " " + building.getLocation()+ " ");
		 * 
		 * // Test for createBuilding JdbcBuildingDAO buildingDAO = new
		 * JdbcBuildingDAO(); Building building = new Building();
		 * building.setBuildingName("Blabla"); building.setLocation("sgsgsg"); if
		 * (buildingDAO.createCheck(building)) {
		 * System.out.println("Successfully created."); } else {
		 * System.out.println("You fucked up smth."); }
		 * 
		 * // Test for deleteBuilding JdbcBuildingDAO buildingDAO = new
		 * JdbcBuildingDAO(); boolean result=buildingDAO.deleteBuilding(5); if (result)
		 * { System.out.println("Successfully deleted."); } else {
		 * System.out.println("You fucked up smth."); }
		 * 
		 * // Test for getAllUsers List<User> users = new ArrayList<>(); JdbcUserDAO
		 * userDAO = new JdbcUserDAO(); users = userDAO.getAllUsers();
		 * System.out.println("Let the fun begin..."); for (Integer i = 0; i <
		 * users.size(); i++) {
		 * System.out.println(users.get(i).getIdUser()+" "+users.get(i).getFirstName()+"
		 * "+users.get(i).getLastName()); for (Integer j = 0; j <
		 * users.get(i).getCourses().size(); j++) {
		 * System.out.println(users.get(i).getCourses().get(j)); } System.out.println();
		 * }
		 * 
		 * //Test delete user JdbcUserDAO userDAO = new JdbcUserDAO();
		 * userDAO.deleteUser(4);
		 * 
		 * //Test update user User user=new User(); user.setFirstName("Orsi");
		 * user.setUsername("noim"); user.setEmail("noim1553@cs.ubbcluj.ro");
		 * user.setLastName("Zagor"); JdbcUserDAO userDAO=new JdbcUserDAO();
		 * userDAO.updateUser(user);
		 * 
		 * 
		 * //Test course delete JdbcCourseDAO courseDAO=new JdbcCourseDAO();
		 * courseDAO.deleteCourse(4);
		 */
	}

}
