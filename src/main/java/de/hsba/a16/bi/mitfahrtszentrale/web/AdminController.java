package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.user.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserServices userServices;

    public AdminController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public String showAllUsers (Model model){
        model.addAttribute("allUsers",userServices.showAllUser());
        return "further/admin-user";
    }
}
