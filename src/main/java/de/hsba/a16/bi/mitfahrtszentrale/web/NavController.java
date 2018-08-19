package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class NavController {
	private User user;

	@ModelAttribute("logedUserInfo")
	public String userInfo() {
		User.getCurrentUser().getFirstName();
		return "fragements\nav";
	}
}
