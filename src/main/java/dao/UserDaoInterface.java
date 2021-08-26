package dao;
import org.example.server.Exceptions.DaoException;
import org.example.core.DTOs.Student;
import java.util.List;

public interface UserDaoInterface {
    public List<User> findAllUsers() throws DaoException;
    public boolean registerUser(User u) throws DaoException;
    public User findUser(int user_id) throws DaoException;
    public boolean checkIfRegistered(User u) throws DaoException;
    public boolean login(int user_id, String password) throws DaoException;
}
