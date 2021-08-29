//Sean Stephens D00211442
package dao;
import dto.VaccineCentre;
import exceptions.DaoException;
import java.util.List;


public interface VaccineCentreDaoInterface {

    public List<VaccineCentre>findAllVaccineCentres() throws DaoException;
    public List<VaccineCentre> findVaccineCentresForUser(int user_id) throws DaoException;
}

