package de.hsba.a16.bi.mitfahrtszentrale.trip;

import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@Table(name = "trip")
@Component
public class Trip {
    @Id @GeneratedValue
    private Long id;
    @Basic(optional = false)
    private String start, end, date;

    private boolean smoking, pet;
    @Basic(optional = false)
    private int freeSeats, price;



    public Long getId() {
        return id;
    }


    public Trip() {
    }


    public Trip(String start, String end, String date, boolean smoking, boolean pet, int freeSeats, int price) {
        this.start = start;
        this.end = end;
        this.date = date;
        this.smoking = smoking;
        this.pet = pet;
        this.freeSeats = freeSeats;
        this.price = price;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isPet() {
        return pet;
    }

    public void setPet(boolean pet) {
        this.pet = pet;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    /* private List<TripElements> tripElementsList;

    public List<TripElements> getTripElementsList (){
        if (tripElementsList==null){
            tripElementsList = new ArrayList<>();
        }
        return tripElementsList;
    }*/




}
