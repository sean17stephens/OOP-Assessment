package dao;
import dto.VaccineCentre;
import dto.VaccineAppointment;
import dto.User;
import exceptions.DaoException;

public interface VaccineAppointmentDaoInterface {

    public boolean updateVaccineAppointmentForUser(String VaccineAppointment) throws DaoException;

}
