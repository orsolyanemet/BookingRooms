package ro.edu.ubb.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for reservation table.
 * 
 * @author Nemet Orsolya, noim1553
 *
 */
@Entity
@Table(name = "bookroom")
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idBookRoom")
	private Integer idReservation;
	@Column(name = "idUserfkey")
	private User user;
	@Column(name = "idRoomfkey")
	private Room room;
	@Column(name = "fromTime")
	private Time fromTime;
	@Column(name = "toTime")
	private Time toTime;
	@Column(name = "date")
	private Date date;
	@Column(name = "idCoursefkey")
	private Course course;
	@Column(name = "idCourseTypefk")
	private CourseTypes courseType;

	public Reservation() {
		super();
	}

	public Reservation(Integer idReservation, User user, Room room, Time fromTime, Time toTime, Date date,
			Course course, CourseTypes courseType) {
		super();
		this.idReservation = idReservation;
		this.user = user;
		this.room = room;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.date = date;
		this.course = course;
		this.courseType = courseType;
	}

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Time getFromTime() {
		return fromTime;
	}

	public void setFromTime(Time fromTime) {
		this.fromTime = fromTime;
	}

	public Time getToTime() {
		return toTime;
	}

	public void setToTime(Time toTime) {
		this.toTime = toTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseTypes getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseTypes courseType) {
		this.courseType = courseType;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", user=" + user + ", room=" + room + ", fromTime="
				+ fromTime + ", toTime=" + toTime + ", date=" + date + ", course=" + course + ", courseType="
				+ courseType + "]";
	}
}