package ro.edu.ubb.entity;

/**
 * Enum for the types of roles.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
public enum RoleType {
	ADMINISTRATOR("Administrator"), PROFESSOR("Professor"), ASSOCIATE_PROFESSOR(
			"Associate Professor"), LECTURER_PROFESSOR(
					"Lecturer Professor"), ASSISTANT("Assistant"), DOCTORAL_STUDENT("Doctoral Student");
	private final String roleTypeName;

	private RoleType(String roleTypeName) {
		this.roleTypeName = roleTypeName;
	}

	public String getRoleType() {
		return roleTypeName;
	}

	public static RoleType valueOfIgnoreCase(String roleTypeName) {
		return valueOf(roleTypeName.replace(' ', '_').toUpperCase());
	}
}