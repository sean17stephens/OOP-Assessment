package dao;
import org.example.core.DTOs.Course;
import org.example.core.DTOs.Student;
import org.example.server.Exceptions.DaoException;
import java.util.List;

public interface VaccineAppointmentDaoInterface {
    public boolean updateChoices(String VaccineCentre) throws DaoException;
    //public List<User> updateCoursesForUser(int caoNumber,  List<String> courses) throws DaoException;


}
