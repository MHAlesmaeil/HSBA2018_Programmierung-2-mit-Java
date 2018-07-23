package de.hsba.a16.bi.mitfahrtszentrale.web;

import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import de.hsba.a16.bi.mitfahrtszentrale.trip.TripServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class IndexController {
    private final TripServices tripServices;

    public IndexController(TripServices tripServices) {
        this.tripServices = tripServices;
    }

    @GetMapping
    public String index (){
        return "index";
    }





}
