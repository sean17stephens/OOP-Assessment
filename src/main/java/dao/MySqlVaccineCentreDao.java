//Sean Stephens D00211442
package dao;

import exceptions.DaoException;
import dto.VaccineCentre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlVaccineCentreDao extends MySqlDao implements VaccineCentreDaoInterface {

    @Override
    public List<VaccineCentre> findAllVaccineCentres() throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<VaccineCentre> vaccinecentres = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM VACCINE_CENTRE";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                String centre_id = rs.getString("centre_id");
                String location = rs.getString("location");
                VaccineCentre v = new VaccineCentre(centre_id, location);
                vaccinecentres.add(v);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllVaccineCentres() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllVaccineCentres() " + e.getMessage());
            }
        }
        return vaccinecentres;     // may be empty
    }

    public List<VaccineCentre> findVaccineCentresForUser(int user_id) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<VaccineCentre> vaccinecentres = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM VACCINE_CENTRE WHERE USER_ID Like ?";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                user_id = rs.getInt("user_id");
                String centre_id = rs.getString("centre_id");
                String location = rs.getString("location");
                VaccineCentre v = new VaccineCentre(centre_id, location);
                vaccinecentres.add(v);
            }
        } catch (SQLException e) {
            throw new DaoException("findVaccineCentresForUser() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findVaccineCentresForUser() " + e.getMessage());
            }
        }
        return vaccinecentres;     // may be empty
    }



}
