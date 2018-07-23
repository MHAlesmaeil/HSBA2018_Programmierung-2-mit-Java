package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import de.hsba.a16.bi.mitfahrtszentrale.user.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new-user")
public class NewUserController {
    private final UserServices userServices;

    public NewUserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public String showNewUserForm (){
        return "/user/new-user";
    }
    @PostMapping
    public String saveNewUser (@ModelAttribute("newUser") User user){
        this.userServices.createUser(user);
        return "/further/success";
    }
}
