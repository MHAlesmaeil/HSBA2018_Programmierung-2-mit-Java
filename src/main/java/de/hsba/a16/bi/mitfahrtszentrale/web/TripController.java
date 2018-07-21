package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripElements;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trips")
public class TripController {

    private final TripServices tripServices;

    public TripController(TripServices tripServices) {
        this.tripServices = tripServices;
    }

   /* @GetMapping(path = "/{id}")
    public String show (@PathVariable("id") Long id, Model model){
        model.addAttribute("singleTrip",tripServices.findeById(id));
        return "trips/show";
    }
    @PostMapping(path = "/{id}")
    public String addEntry (@PathVariable("id") Long id, TripElements elemet){
        System.out.println("request has arrived");
        Trip trip = tripServices.findeById(id);
        tripServices.addTripElement(trip, elemet);
        return "redirect:/trips/"+id;
    }
    @PostMapping(path = "/{id}/delete")
    public String delete (@PathVariable("id") Long id){
         tripServices.delete(id);
        return "redirect:/index";
    }*/


}
