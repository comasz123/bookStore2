package store.database;

import org.springframework.stereotype.Component;
import store.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDataBase {
    private List<User> users = new ArrayList<>();

    public UserDataBase (){
        users.add(new User(1, "admin", "admin"));
        users.add(new User(2, "janusz", "janusz"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByLogin(String login) {
        for (User user: this.users) {
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

}
