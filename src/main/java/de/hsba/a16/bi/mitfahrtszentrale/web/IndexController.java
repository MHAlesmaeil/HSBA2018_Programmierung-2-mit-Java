package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    private final TripServices tripServices;

    public IndexController(TripServices tripServices) {
        this.tripServices = tripServices;
    }

    @GetMapping("/index")
    public String index (Model model){
        model.addAttribute("showAll", tripServices.getAllTrips());
        return "index";
    }
    @PostMapping("/index")
    public String newTrip (@ModelAttribute("trip") Trip trip){
        tripServices.create(trip.getName());
        return "redirect:/index";
    }

}
