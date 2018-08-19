package de.hsba.a16.bi.mitfahrtszentrale.web;


import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Personal Controller is to control the post of a user
@Controller
public class PersonalController {
	private final TripServices tripServices;
	private User user;

	public PersonalController(TripServices tripServices) {
		this.tripServices = tripServices;
	}

	@GetMapping("/personal")
	public String user(Model model) {
		model.addAttribute("userPosts", tripServices.findUsertrips());
		return "user/personal";
	}
}
