package ro.edu.ubb.common.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import ro.edu.ubb.entity.Course;
import ro.edu.ubb.entity.Reservation;
import ro.edu.ubb.entity.Room;
import ro.edu.ubb.entity.User;

public interface ReservationDAO {
	List<Reservation> getAllReservations();

	Reservation findbyDate(Date date);

	Reservation findByTime(Time fromTime, Time toTime, Date date);

	Reservation findByUser(User user);

	Reservation findByRoom(Room room);

	Reservation findByCourse(Course course);

	Reservation createReservation(Reservation reservation);

	void updateReservation(Reservation reservation);

	boolean deleteReservation(Integer idReservation);

	boolean createCheck(Reservation reservation);

	boolean deleteReservationAfterXMinutes(Integer idReservation);

}
