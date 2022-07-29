package store.database;

import store.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    List<User> getUsers();
    Optional<User> getUserByLogin(String login);
    boolean isLoginExisting(String login);
    void addUser (User user);

}
