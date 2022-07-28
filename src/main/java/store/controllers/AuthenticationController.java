package store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import store.database.UserDataBase;
import store.model.User;

@Controller
public class AuthenticationController {
    @Autowired
    UserDataBase userDataBase;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user){
        User userFromDatabase = this.userDataBase.getUserByLogin(user.getLogin());
        if(userFromDatabase != null && userFromDatabase.getPassword().equals(user.getPassword())){
                return "redirect:/main";
            }
        return "redirect:/login";
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register () {
        return "register";
    }
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String register(@ModelAttribute User user){
        System.out.println(user.getLogin());
        return "redirect:/register";
    }
}
