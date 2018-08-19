package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AllTripsController {
	private  final TripServices tripServices;

	public AllTripsController(TripServices tripServices) {
		this.tripServices = tripServices;
	}

	// die Seite von allen Fahrt zeigen
	@GetMapping("/all-trips")
	public String showForm (Model model){
		model.addAttribute("allTrips", tripServices.getAllTrips());
		return "trips/all-trips";
	}

	// delete Controller
	@PostMapping("/all-trips/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		tripServices.delete(id);
		return "redirect:/all-trips";
	}
	@PostMapping("/all-trips/bookable/{id}")
	public String makeItBookable(@PathVariable("id") Long id) {
		tripServices.bookable(id);
		return "redirect:/personal";
	}
}
