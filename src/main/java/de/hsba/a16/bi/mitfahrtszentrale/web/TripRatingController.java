package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripRating;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import de.hsba.a16.bi.mitfahrtszentrale.user.UserService;
import de.hsba.a16.bi.mitfahrtszentrale.web.fehler.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trips/{id}")
public class TripRatingController {
	private final TripServices tripServices;


	public TripRatingController(TripServices tripServices) {
		this.tripServices = tripServices;
	}
	// Fahrt mit den ID={id} aufrufen .. wenn die Fahrt nicht exitiert wird eine Exception aufgelöst
	@ModelAttribute("tripNumber")
	public Trip getTrip(@PathVariable("id") Long id){
		Trip rating = tripServices.findTripById(id);
		if (rating == null){
			throw new NotFoundException();
		}
		return rating;
	}
	@GetMapping
	public String showRating (Model model, @PathVariable("id") Long id){
		model.addAttribute("ratingform", new TripRating());
		model.addAttribute("showAvailableRating", tripServices.findTripRating(id));
		return "trips/rating";
	}
	@PostMapping
	public String sendRating (@PathVariable("id") Long id, @ModelAttribute("ratingForm") TripRating tripRating, BindingResult bindingResult, Model model){
		Trip trip = getTrip(id);
		if (bindingResult.hasErrors()){
			//todo validation need to be constructed here
			return "trips/rating";
		}
		 tripServices.addRating(trip, tripRating);
		return "redirect:/index";

	}


}
