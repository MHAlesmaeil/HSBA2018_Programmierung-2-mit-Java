package de.hsba.a16.bi.mitfahrtszentrale.trip;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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

	// add rating and making a trip and rating as parameter to call this function
	public void addRating (Trip trip, TripRating rating){
		rating.setTrip(trip);
		trip.getRaing().add(rating);

	}

	// for test purpose a trip has been created
	@PostConstruct
	public void init() {
		if (repository.count() == 0) {
			create(new Trip("hh", "hh", "01.12.2018 ", false, false, false, 12, 12));
		}
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
