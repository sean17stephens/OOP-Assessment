package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.server.Exceptions.DaoException;
import org.example.core.DTOs.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlUserDao extends MySqlDao implements UserDaoInterface {

    public List<User> findAllUsers() throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM USER";
            ps = con.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User u = new User(user_id, email, password);
                users.add(u);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllUsers() " + e.getMessage());
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
                throw new DaoException("findAllUsers() " + e.getMessage());
            }
        }
        return users;     // may be empty
    }

    public boolean registerUser(User u) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean success = false;

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "INSERT INTO USER VALUES (?,?,?)";
            ps = con.prepareStatement(query);

            ps.setInt(1, u.getuser_id());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());

            //Using a PreparedStatement to execute SQL - UPDATE...
            success = (ps.executeUpdate() == 1);

        } catch (SQLException e) {
            throw new DaoException("insertUser() " + e.getMessage());
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
                throw new DaoException("insertUser() " + e.getMessage());
            }
        }
        return success;
    }

    @Override
    public User findUser(int user_id) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            con = this.getConnection();

            String query = "SELECT * FROM User WHERE user_id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, user_id);  // search based on the cao number

            rs = ps.executeQuery();
            if (rs.next()) {
                user_id = rs.getInt("user_id");
                String email = rs.getString("email");
                String password = rs.getString("password");

                u = new User(user_id, email, password);
            }
        } catch (SQLException e) {
            throw new DaoException("findUser" + e.getMessage());
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
                throw new DaoException("findUser() " + e.getMessage());
            }
        }
        return u;     // s may be null
    }
    public boolean checkIfRegistered(User u) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean success = false;

        try {
            con = this.getConnection();

            String query = "INSERT INTO USER VALUES (?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, u.getuser_id()); // search based on the cao number
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());

            //Using a PreparedStatement to execute SQL - UPDATE...
            success = (ps.executeUpdate() == 1);


        } catch (SQLException e) {
            throw new DaoException("checkIfRegistered" + e.getMessage());
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
                throw new DaoException("checkIfRegistered() " + e.getMessage());
            }
        }
        return success;     // s may be null
    }

    public boolean login( int user_id, String password ) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        boolean result = false;
        ResultSet rs = null;
        String query = "SELECT * FROM user WHERE user_id=? AND password=? LIMIT 1";

        try
        {
            ps = this.getConnection().prepareStatement(query);

            ps.setInt(1, user_id);
            ps.setString(2, password);

            ResultSet queryResult = ps.executeQuery();

            result =  queryResult.next();

        }
        catch (SQLException error)
        {
            System.out.println("issue with the sql query");
            System.out.println(error.getMessage());
            System.out.println(error.getLocalizedMessage());
            error.printStackTrace();
        }
        finally {
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
                throw new DaoException("login() " + e.getMessage());
            }
        }
        return result;     // s may be null
    }

}


