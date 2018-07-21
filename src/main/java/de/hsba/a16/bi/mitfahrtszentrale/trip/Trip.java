package de.hsba.a16.bi.mitfahrtszentrale.trip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class Trip {
    @Id @GeneratedValue
    private Long id;

    @NotNull(message = "please do not leave it empty")
    private String name;

    public Trip(@NotNull(message = "please do not leave it empty") String name) {
        this.name = name;
    }

    public Trip() {
    }
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
