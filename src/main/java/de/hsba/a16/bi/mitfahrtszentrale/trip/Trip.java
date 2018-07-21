package de.hsba.a16.bi.mitfahrtszentrale.trip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "trip")
public class Trip {
    @Id @GeneratedValue
    private Long id;

    private String start, end;

    public Long getId() {
        return id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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




}
