package store.services;

import org.springframework.ui.Model;
import store.model.User;

public interface IAuthenticationService {
    void authenticate(User user);
    void register (User user);
    void logout ();

    void addCommonInfoToModel(Model model);

}
