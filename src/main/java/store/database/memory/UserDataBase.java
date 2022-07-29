package store.database.memory;

import org.springframework.stereotype.Component;
import store.database.IUserDAO;
import store.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDataBase implements IUserDAO {
    private List<User> users = new ArrayList<>();

    public UserDataBase (){
        users.add(new User(1, "admin", "21232f297a57a5a743894a0e4a801fc3"));
        users.add(new User(2, "janusz", "087d9c5e13bdd64a82bef8e013625c32"));
    }

    public List<User> getUsers() {
        return users;
    }

   public Optional<User> getUserByLogin(String login){
        for(User user : this.users){
            if(user.getLogin().equals(login)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
   }
    public boolean isLoginExisting(String login){
        return getUserByLogin(login).isPresent();
    }
    public void addUser (User user){
        this.users.add(user);
    }

}
