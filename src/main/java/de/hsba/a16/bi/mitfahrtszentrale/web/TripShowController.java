package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/all-trips")
public class TripShowController {
    private final TripServices tripServices;

    public TripShowController(TripServices tripServices) {
        this.tripServices = tripServices;
    }
    @GetMapping
    public String index (Model model){
        model.addAttribute("allTrips", tripServices.getAllTrips());
        return "trips/all-trips";
    }
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id")Long id){
        tripServices.delete(id);
        return "redirect:/all-trips";
    }
}
