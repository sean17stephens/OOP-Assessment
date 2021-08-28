package dao;
import dto.VaccineCentre;
import dto.User;
import exceptions.DaoException;
import java.util.List;

public interface VaccineAppointmentDaoInterface {
    public boolean updateChoices(String VaccineCentre) throws DaoException;
    //public List<User> updateCoursesForUser(int caoNumber,  List<String> courses) throws DaoException;


}
