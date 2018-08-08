package de.hsba.a16.bi.mitfahrtszentrale.trip;

import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *Diese Klasse definiert eine Fahrt
*/
@Entity
@Table(name = "trip")
@Component
public class Trip {
    @Id @GeneratedValue
    private Long id;
    @Basic(optional = false)
    private String start, end;

    private boolean smoking, pet, bookable;
    @Basic(optional = false)
    private int freeSeats;
    @Basic(optional = false)
    private int price;


    private String date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "trip")
	private List<TripRating> raing;

    public Long getId() {
        return id;
    }

    public Trip() {
    }

    public Trip( String start, String end, String date, boolean smoking, boolean pet, boolean bookable, int freeSeats, int price) {

        this.start = start;
        this.end = end;
        this.date = date;
        this.smoking = smoking;
        this.pet = pet;
        this.freeSeats = freeSeats;
        this.price = price;
        this.bookable= bookable;
    }

	public boolean isBookable() {
		return bookable;
	}

	public void setBookable(boolean bookable) {
		this.bookable = bookable;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
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

	public List<TripRating> getRaing() {
		if (raing== null){
			raing= new ArrayList<>();
		}
		return raing;
	}

	public void setRaing(List<TripRating> raing) {
		this.raing = raing;
	}
}
