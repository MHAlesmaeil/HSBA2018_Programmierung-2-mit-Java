package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import de.hsba.a16.bi.mitfahrtszentrale.user.UserService;
import de.hsba.a16.bi.mitfahrtszentrale.web.validation.TripFormAssembler;
import de.hsba.a16.bi.mitfahrtszentrale.web.validation.TripFormValidation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class NewTripController {
	private  final TripServices tripServices;
	private final TripFormAssembler formAssembler;

	public NewTripController(TripServices tripServices, TripFormAssembler formAssembler) {
		this.tripServices = tripServices;
		this.formAssembler = formAssembler;
	}

	@PreAuthorize("authenticated")
	@GetMapping("/new-trip")
	public String showForm (Model model){
		model.addAttribute("newTripForm", new TripFormValidation());


		return "trips/new-trip";

	}



	@PreAuthorize("authenticated")
	@PostMapping("/new-trip")
	public String createTrip (@ModelAttribute("newTripForm")@Valid TripFormValidation tripFormValidation, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "trips/new-trip";
		}
		Trip trip = new Trip();
		tripServices.create(formAssembler.update(trip,tripFormValidation));
		return "redirect:/index";
	}
}
