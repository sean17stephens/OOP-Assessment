package dao;
import java.sql.*;
import org.example.server.Exceptions.DaoException;
import org.example.core.DTOs.Course;
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

    public VaccineCentre findVaccineCentre(String centre_id) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        VaccineCentre v = null;
        try {
            con = this.getConnection();
            //Get connection object using the methods in the super class (MySqlDao.java)...

            String query = "SELECT * FROM VACCINECENTRE WHERE CENTRE_ID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, centre_id);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            if (rs.next()) {
                centre_id = rs.getString("CENTRE_ID");
                String location = rs.getString("LOCATION");
                VaccineCentre v = new VaccineCentre(centre_id, location);
            }
        } catch (SQLException e) {
            throw new DaoException("findVaccineCentre() " + e.getMessage());
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
                throw new DaoException("findVaccineCentre() " + e.getMessage());
            }

            return v;  // Course may be empty
        }
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

/*
public List<User> updateCoursesForUser(int caoNumber, List<String> courses) throws DaoException{
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
        List<User> users = new ArrayList<>();
            try {
                //Get connection object using the methods in the super class (MySqlDao.java)...
                con = this.getConnection();

                String query = "UPDATE course SET COURSEID = ? where caoNumber = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, "%" + courses + "%");

                //Using a PreparedStatement to execute SQL...
                rs = ps.executeQuery();
                while (rs.next()) {
                    caoNumber = rs.getInt("caoNumber");
                    String username = rs.getString("USERNAME");
                    String password = rs.getString("PASSWORD");
                    String lastname = rs.getString("LAST_NAME");
                    String firstname = rs.getString("FIRST_NAME");
                    Users u = new user(caoNumber, username, firstname, lastname, username, password);
                   Users.add(u);
                }


            } catch (SQLException e) {
                throw new DaoException("updateCoursesForUser() " + e.getMessage());
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
                    throw new DaoException("updatePassword() " + e.getMessage());
                }

                return users;     // may be empty
            }
        }
    }

 */
/*
}
}
 */
