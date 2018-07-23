package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new-trip")
public class newTripController {

    private final TripServices tripServices;

    public newTripController(TripServices tripServices) {
        this.tripServices = tripServices;
    }

    @GetMapping
    public String showForm (){
        return "trips/new-trip";
    }

    @PostMapping
    public String newTrip (@ModelAttribute("newTrip") Trip trip){
        tripServices.create(trip);
        return "redirect:/all-trips";
    }
}
