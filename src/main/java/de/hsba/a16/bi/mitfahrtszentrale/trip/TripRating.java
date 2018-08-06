/*
package de.hsba.a16.bi.mitfahrtszentrale.trip;

import sun.font.TrueTypeFont;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class TripRating {

	@Id@GeneratedValue
	private Long id;

	@ManyToOne
	private Trip trip;

	@Basic(optional = true)
	private String comment;

	private BigDecimal rate;

	public TripRating() {
	}

	int numberOfUsers = 0;
	public TripRating(int numberOfUsers, Trip trip, String comment, BigDecimal rate) {
		// number of user who called this function
		this.numberOfUsers = numberOfUsers;
		this.trip = trip;
		this.comment = comment;
		this.rate = rate;
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

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers += numberOfUsers ++;
	}
	// calculation of the rate

}
*/
