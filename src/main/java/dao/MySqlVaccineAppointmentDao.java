package dao;
import dto.User;
import dto.VaccineCentre;
import exceptions.DaoException;
import dto.VaccineAppointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlSVaccineAppointmentDao extends MySqlDao implements VaccineAppointmentDaoInterface {
    public boolean updateChoices(String VaccineCentre) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean success = false;

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "UPDATE * FROM VACCINE_APPOINTMENT Where CENTRE_ID AND APPOINTMENT_TIME = ?,?";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                String centre_id = rs.getString("centre_id");
                String location = rs.getString("location");
                int user_id = rs.getInt("user_id");

                VaccineCentre v = new VaccineCentre(centre_id, location);


                //Using a PreparedStatement to execute SQL - UPDATE...
                success = (ps.executeUpdate() == 1);
            }
        } catch (SQLException e) {
            throw new DaoException("updateChoices() " + e.getMessage());
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
                throw new DaoException("updateChoices() " + e.getMessage());
            }

            return true;     // may be empty
        }
    }
}

