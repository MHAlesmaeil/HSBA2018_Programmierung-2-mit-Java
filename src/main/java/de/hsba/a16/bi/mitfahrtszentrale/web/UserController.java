package de.hsba.a16.bi.mitfahrtszentrale.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/user")
public class UserController {
    @GetMapping()
    public String newUser (){
        return "user/login";
    }
}
