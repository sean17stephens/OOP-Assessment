package dao;
import dto.VaccineCentre;
import dto.VaccineAppointment;
import dto.User;
import exceptions.DaoException;
import java.util.List;

public interface VaccineAppointmentDaoInterface {
    public boolean updateVaccineAppointmentForUser(String VaccineAppointment) throws DaoException;
    //public List<User> updateVaccineAppointmentForUser(int user_id,  List<String> vaccinecentres) throws DaoException;


}
