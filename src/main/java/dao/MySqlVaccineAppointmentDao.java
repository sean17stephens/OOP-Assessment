//Sean Stephens D00211442
package dao;

import exceptions.DaoException;
import dto.VaccineAppointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlVaccineAppointmentDao extends MySqlDao implements VaccineAppointmentDaoInterface {

    public boolean updateVaccineAppointmentForUser(String VaccineAppointment) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean success = false;

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "UPDATE * FROM VACCINE_APPOINTMENT Where Centre_id AND Location = ?,?";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {

                int user_id = rs.getInt("user_id");
                String location = rs.getString("location");
                String centre_id = rs.getString("centre_id");

                VaccineAppointment v = new VaccineAppointment(user_id, location, centre_id);
                //Using a PreparedStatement to execute SQL - UPDATE...
                success = (ps.executeUpdate() == 1);
            }
        } catch (SQLException e) {
            throw new DaoException("updateVaccineAppointmentForUser() " + e.getMessage());
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
                throw new DaoException("updateVaccineAppointmentForUser() " + e.getMessage());
            }

            return true;     // may be empty
        }
    }
}

