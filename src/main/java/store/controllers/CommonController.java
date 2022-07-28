package store.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import store.database.BookDataBase;

@Controller
public class CommonController {
    @Autowired
    BookDataBase bookDataBase;


    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        System.out.println(this.bookDataBase.getBooks().get(1).getAuthor());
        model.addAttribute("books", this.bookDataBase.getBooks());
        return "main";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String main(){
        return "redirect:/main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }

}
