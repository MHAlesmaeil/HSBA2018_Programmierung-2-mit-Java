package de.hsba.a16.bi.mitfahrtszentrale.web;


import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import de.hsba.a16.bi.mitfahrtszentrale.user.UserService;
import de.hsba.a16.bi.mitfahrtszentrale.web.validation.SignupFormAssembler;
import de.hsba.a16.bi.mitfahrtszentrale.web.validation.SignupFormValidation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class SignupController {
    private final UserService userService;
    private final SignupFormAssembler formAssembler;

	public SignupController(UserService userService, SignupFormAssembler formAssembler) {
		this.userService = userService;
		this.formAssembler = formAssembler;
	}

	@GetMapping("/signup")
    public String signupShow (Model model){


       model.addAttribute("users", userService.findAll());
       model.addAttribute("signupForm", new SignupFormValidation());

        return "signup";
    }




    @PostMapping("/signup")
    public String createUser (@ModelAttribute("signupForm")@Valid SignupFormValidation formValidation, BindingResult bindingResult){

		if (bindingResult.hasErrors()){
			return "signup";
		}
		User user = new User();

			this.userService.createUserByEntiy(formAssembler.update(user, formValidation));

        return "redirect:/index";
    }
}
