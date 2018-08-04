package de.hsba.a16.bi.mitfahrtszentrale.web.validation;

import de.hsba.a16.bi.mitfahrtszentrale.trip.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripFormAssembler {
	public TripFormValidation toForm(Trip trip){
		TripFormValidation tripFormValidation = new TripFormValidation();
		return tripFormValidation;
	}

	public Trip update (Trip trip, TripFormValidation tripFormValidation){
		trip.setBookable(tripFormValidation.isBookable());
		trip.setSmoking(tripFormValidation.isSomking());
		trip.setPet(tripFormValidation.isPet());
		trip.setPrice(tripFormValidation.getPrice());
		trip.setStart(tripFormValidation.getStart());
		trip.setDate(tripFormValidation.getDate());
		trip.setEnd(tripFormValidation.getEnd());
		trip.setFreeSeats(tripFormValidation.getFreeSeats());
		return trip;
	}

}
