package de.hsba.a16.bi.mitfahrtszentrale.trip;

import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

	@ManyToOne
	private User owner;

	// TODO: 13.08.2018 das muss comparebale gemacht werden damit eine Fahrt nicht mehr erscheinen, wenn das Datum vorbei ist.
    private String date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "trip")
	private List<TripRating> ratingList;

    public Long getId() {
        return id;
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

	public List<TripRating> getRatingList() {
		if (ratingList == null){
			ratingList = new ArrayList<>();
		}
		return ratingList;
	}
	public void setRatingList(List<TripRating> ratingList) {
		this.ratingList = ratingList;
	}

	@Transient // diese Spalte wird nicht in der Datenbank gespeichert
	private double sum= 0;
	@Transient // diese Spalte wird nicht in der Datenbank gespeichert
    private double numberOfIteration=0;
	// Der Durchschnitt wird hier als double berechnet werden
	private double averageRate;
	// Der Durchschnitt wird hier als String ausgezeigt, denn es ist einfacher zu formallieren
	private String averageRatingInText;

	public String getAverageRatingInText() {
		// ruffen diese Methode auf, um den Durchschnitt berechnet zu werden
		this.averageRateb();
		return averageRatingInText;
	}

	public void setAverageRatingInText(String averageRatingInText) {
		this.averageRatingInText = averageRatingInText;
	}

	// Rechnen von dem Durchschnitt
	// TODO: 13.08.2018: Hinweis-> solche Methode könnte bei der Buchung angewendet werden, um die Zahl der Verfügbare Plätze bzw. den gesamten Preis zu berechnet.
	private double averageRateb(){
		for(TripRating local:getRatingList()){
			sum=(sum+local.getRate());
			numberOfIteration++;
		}
		if(numberOfIteration==0){
			// wenn keine Bewertung gibt
			averageRatingInText = "No Rating Yet";
			return averageRate=0;
		}
		averageRate=sum/numberOfIteration;
		// konvertieren den Double Wert als Text mit Format
		averageRatingInText = String.format("%.1f", averageRate);
		setAverageRatingInText(averageRatingInText);
		setAverageRate(averageRate);
		return averageRate;
	}
	public void setAverageRate(double averageRate) {
		this.averageRate = averageRate;
	}
	public double getAverageRate() {
		return averageRate;
	}

	public User getOwner() {
		return owner;
	}

	@PrePersist
	private void onPersist() {
		this.owner = User.getCurrentUser();
	}

	public boolean isOwnedByCurrentUser() {
		return this.owner != null && this.owner.equals(User.getCurrentUser());
	}

}
