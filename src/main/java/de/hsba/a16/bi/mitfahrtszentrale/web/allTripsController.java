package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class allTripsController {
	private  final TripServices tripServices;

	public allTripsController(TripServices tripServices) {
		this.tripServices = tripServices;
	}

	// die Seite von allen Fahrt zeigen
	@GetMapping("/all-trips")
	public String showForm (Model model){
		model.addAttribute("allTrips", tripServices.getAllTrips());
		return "trips/all-trips";
	}

	@PostMapping("/all-trips/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		tripServices.delete(id);
		return "redirect:/all-trips";
	}
}
