package de.hsba.a16.bi.mitfahrtszentrale.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.transaction.TransactionScoped;
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
	private List<TripRating> ratingList;

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
	@Bean
	public List<TripRating> getRatingList() {
		if (ratingList == null){
			ratingList = new ArrayList<>();
		}
		return ratingList;
	}

	public void setRatingList(List<TripRating> ratingList) {
		this.ratingList = ratingList;
	}

	@Transient
	private double sum= 0;
    @Transient
    private double numberOfIteration=0;
    private double averageRate;

	private String averageRatingInText;

	public String getAverageRatingInText() {
		this.averageRateb();
		return averageRatingInText;
	}

	public void setAverageRatingInText(String averageRatingInText) {
		this.averageRatingInText = averageRatingInText;
	}

	@PostConstruct
	private double averageRateb(){

		for(TripRating local:getRatingList()){

			sum=(sum+local.getRate());
			System.out.println("SUm of average rate"+sum);
			numberOfIteration++;
			System.out.println("Numbe of iteration "+ numberOfIteration);
		}
		if(numberOfIteration==0){
			return averageRate=0;
		}
		averageRate=sum/numberOfIteration;
		System.out.println(averageRate);
		averageRatingInText=String.format("%.2f",averageRate);
		setAverageRatingInText(averageRatingInText);
		setAverageRate(averageRate);
		return averageRate;
	}
	public void setAverageRate(double averageRate) {

		this.averageRate = averageRate;
	}
	public double getAverageRate() {
		this.averageRateb();
		return averageRate;
	}



}
