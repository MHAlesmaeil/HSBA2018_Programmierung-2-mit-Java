package de.hsba.a16.bi.mitfahrtszentrale.trip;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Trip {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @NotNull(message = "please do not leave it empty")
    private String name;

   /* private List<TripElements> tripElementsList;

    public List<TripElements> getTripElementsList (){
        if (tripElementsList==null){
            tripElementsList = new ArrayList<>();
        }
        return tripElementsList;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
