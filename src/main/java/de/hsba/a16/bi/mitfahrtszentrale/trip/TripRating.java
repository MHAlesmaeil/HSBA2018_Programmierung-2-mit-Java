package de.hsba.a16.bi.mitfahrtszentrale.trip;
import javax.persistence.*;

/**
 *Diese Klasse definiert die Bewertung einer Fahrt
 *
 * todo : Eine Funktion muss hier erstellt weden, um alle Bewertungen einer Fahrt zu rechnen und durch eine lokale variable zu dividieren, um die durchschnit der Wertung zu bekommen
*/
@Entity
public class TripRating {

	@Id@GeneratedValue
	private Long id;
	@ManyToOne
	private Trip trip;
	@Basic(optional = true)
	private String comment;
	private int rate;

	// für die leere Form
	public TripRating() {
	}

	public TripRating(Trip trip, String comment, int rate) {
		// number of user who called this function
		this.trip = trip;
		this.comment = comment;
		this.rate = rate;
	}
	public Long getId() {
		return id;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
