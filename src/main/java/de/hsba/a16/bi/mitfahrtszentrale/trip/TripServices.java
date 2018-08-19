package de.hsba.a16.bi.mitfahrtszentrale.trip;


import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class TripServices {
	// Variable for trip repository
	private final TripRepository repository;
	// Varible for trip rating repository
	private final TripRatingRepository ratingRepository;
	// Constructor
	public TripServices(TripRepository repository, TripRatingRepository ratingRepository) {
		this.repository = repository;
		this.ratingRepository = ratingRepository;
	}
	// creating a trip
	public void create(Trip trip) {
		repository.save(trip);
	}
	// finding a trip by ID
	public Trip findTripById (Long id){
		return repository.findById(id).orElse(null);
	}
	// get all trips to repeat them in foreach
	public Collection<Trip> getAllTrips() {
		return repository.findAll();
	}

	// delete a trip
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	// make it a trip bookable
	public void bookable (Long id){
		Trip trip = repository.findById(id).orElse(null);
		boolean temp = trip.isBookable();
		// if true turn it false
		if (temp==true){
			temp=false;}
			else{
				temp= true;
		}
		trip.setBookable(temp);
	}
	// add rating and making a trip and rating as parameter to call this function
	public void addRating (Trip trip, TripRating rating){
		rating.setTrip(trip);
		trip.getRatingList().add(rating);
	}
	// find the private posts of current user.
	public Collection<Trip> findUsertrips() {
		return repository.findAllByOwnedByCurrentUser(User.getCurrentUser());
	}


	// this area is for triprating
	//find all rating
	public TripRating findTripRating(Long id) {
		return ratingRepository.findById(id).orElse(null);
	}
	// save rating
	public TripRating saveRating (TripRating rating){
		return ratingRepository.save(rating);
	}

}
