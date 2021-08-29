package dao;
import exceptions.DaoException;
import dto.User;

public interface UserDaoInterface {
    public boolean registerUser(User u) throws DaoException;
    public User findUser(int user_id) throws DaoException;
    public boolean checkIfRegistered(User u) throws DaoException;
    public boolean login(int user_id, String password) throws DaoException;
}
