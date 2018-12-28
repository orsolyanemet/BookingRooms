package ro.edu.ubb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for coursetype table.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
@Entity
@Table(name = "coursetype")
public class CourseTypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idCourseType")
	private Integer idCourseType;
	@Column(name = "courseTypeName")
	private String courseTypeName;

	public CourseTypes() {
		super();
	}

	public CourseTypes(Integer idCourseType, String courseTypeName) {
		super();
		this.idCourseType = idCourseType;
		this.courseTypeName = courseTypeName;
	}

	public Integer getIdCourseType() {
		return idCourseType;
	}

	public void setIdCourseType(Integer idCourseType) {
		this.idCourseType = idCourseType;
	}

	public String getCourseTypeName() {
		return courseTypeName;
	}

	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}

	@Override
	public String toString() {
		return "CourseTypes [idCourseType=" + idCourseType + ", courseTypeName=" + courseTypeName + "]";
	}
}
