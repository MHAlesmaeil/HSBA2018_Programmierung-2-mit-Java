package de.hsba.a16.bi.mitfahrtszentrale.web;



import de.hsba.a16.bi.mitfahrtszentrale.web.validation.SignupFormValidation;
import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import de.hsba.a16.bi.mitfahrtszentrale.user.UserService;
import de.hsba.a16.bi.mitfahrtszentrale.web.validation.SignupFormAssembler;
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
	// TODO: 13.08.2018 Form Validation für diese Seite muss f?r diese Seite erstellt werden

	public SignupController(UserService userService, SignupFormAssembler formAssembler) {
		this.userService = userService;
		this.formAssembler = formAssembler;
	}
	//  jeder kann den URL aufrufen
	@GetMapping("/signup")
    public String signupShow (Model model){
		// nur f?r Testzwecke todo löschen, wenn Ihr das nicht mehr bracht .. vergis bitte auch nicht den Code bei HTML zu l?schen auch
       model.addAttribute("signupForm", new SignupFormValidation());
        return "signup";
    }
    // Objekt sigupForm wird hier behandlt
    @PostMapping("/signup")
    public String createUser (@ModelAttribute("signupForm")@Valid SignupFormValidation formValidation, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "signup";
		}
		User user = new User();
		try {
			this.userService.createUserByEntiy(formAssembler.update(user, formValidation));
		} catch (Exception e) {
			// TODO: 13.08.2018: Detailierte Exception muss hier angewendet werden
			return "signup";
		}
        return "redirect:/index";
    }
}
