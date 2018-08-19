package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	private TripServices tripServices;

	// Es ist immer noch nicht benutzt .. todo ist es zu diskutieren, was wir in der Index seite Zeigen soll
    @GetMapping("/index")
    public String index() {
        return "/index";
    }

    // jede kann diesen URL aufrufen
    @GetMapping("/login")
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth instanceof AnonymousAuthenticationToken ? "login" : "redirect:/";
    }
}
