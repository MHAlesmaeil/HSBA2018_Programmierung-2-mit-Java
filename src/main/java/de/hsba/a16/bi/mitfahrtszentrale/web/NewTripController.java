package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.web.validation.TripFormAssembler;
import de.hsba.a16.bi.mitfahrtszentrale.web.validation.TripFormValidation;
import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
	// die Seite von neuer Fahrt zu zeigen
	@PreAuthorize("authenticated")// nur wenn ein Benutzer eingemeldt ist, kann er diesen URL aufrufen
	@GetMapping("/new-trip") // url
	public String showForm (Model model){
		model.addAttribute("newTripForm", new TripFormValidation());
		return "trips/new-trip";
	}
	// gleich wie oben
	@PreAuthorize("authenticated")
	@PostMapping("/new-trip")
	public String createTrip (@ModelAttribute("newTripForm")@Valid TripFormValidation tripFormValidation, BindingResult bindingResult){
		// wenn ein Fehler eintritt
		if (bindingResult.hasErrors()){
			return "trips/new-trip";}
		// sonst
		Trip trip = new Trip();
		tripServices.create(formAssembler.update(trip, tripFormValidation));
		return "redirect:/index";
	}
}
