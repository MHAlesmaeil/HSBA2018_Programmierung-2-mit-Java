package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/all-trips")
public class allTripsController {
	private  final TripServices tripServices;

	public allTripsController(TripServices tripServices) {
		this.tripServices = tripServices;
	}

	// die Seite von allen Fahrt zeigen
	@GetMapping
	public String showForm (Model model){
		model.addAttribute("allTrips", tripServices.getAllTrips());
		return "trips/all-trips";
	}
}
