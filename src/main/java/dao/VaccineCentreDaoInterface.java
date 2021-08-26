package dao;
import org.example.core.DTOs.Course;
import org.example.server.Exceptions.DaoException;
import java.util.List;


public interface VaccineCentreDaoInterface {
    public List<VaccineCentre>findAllVaccineCentres() throws DaoException;
    public VaccineCentre findVaccineCentre(String centre_id) throws DaoException;

    public List<VaccineCentre> findVaccineCentresForUser(int user_id) throws DaoException;

}

