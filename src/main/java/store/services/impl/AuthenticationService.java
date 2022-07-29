package store.services.impl;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import store.database.IUserDAO;
import store.exceptions.LoginAlreadyExistsException;
import store.model.User;
import store.services.IAuthenticationService;
import store.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    IUserDAO userDAO;
    @Resource
    SessionObject sessionObject;

    public void authenticate(User user){
        Optional<User> userFromDatabase = this.userDAO.getUserByLogin(user.getLogin());
        if(userFromDatabase.isPresent() &&
                userFromDatabase.get().getPassword().equals(DigestUtils.md5Hex(user.getPassword()))){
            this.sessionObject.setUser(userFromDatabase.get());
        }
    }

    public void register (User user){
        if(this.userDAO.isLoginExisting(user.getLogin())){
             throw new LoginAlreadyExistsException();
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.addUser(user);
    }
    public void logout (){
        this.sessionObject.setUser(null);
    }

    @Override
    public void addCommonInfoToModel(Model model) {
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("user", this.sessionObject.getUser());
    }
}
