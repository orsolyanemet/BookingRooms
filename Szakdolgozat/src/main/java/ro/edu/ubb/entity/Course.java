package ro.edu.ubb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for course table.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
@Entity
@Table(name = "course")
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7624122568295225966L;

	@Id
	@Column(name = "idCourse")
	private Integer idCourse;
	@Column(name = "courseName")
	private String courseName;
	@Column(name = "nrOfAttandance")
	private Integer nrOfAttandance;
	private List<CourseType> courseType;

	public Course() {
		super();
	}

	public Course(Integer idCourse, String courseName, Integer nrOfAttandance, List<CourseType> courseType) {
		super();
		this.idCourse = idCourse;
		this.courseName = courseName;
		this.nrOfAttandance = nrOfAttandance;
		this.courseType = courseType;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getNrOfAttandance() {
		return nrOfAttandance;
	}

	public void setNrOfAttandance(Integer nrOfAttandance) {
		this.nrOfAttandance = nrOfAttandance;
	}

	public List<CourseType> getCourseType() {
		return courseType;
	}

	public void setCourseType(List<CourseType> courseType) {
		this.courseType = courseType;
	}

	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", courseName=" + courseName + ", nrOfAttandance=" + nrOfAttandance
				+ ", courseType=" + courseType + "]";
	}
}
