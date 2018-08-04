package de.hsba.a16.bi.mitfahrtszentrale.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service
@Transactional
public class TripServices {
    private final TripRepository repository;


    public TripServices(TripRepository repository) {
        this.repository = repository;
    }

    public void createTripBySet (String start, String end, String date, boolean smoking, boolean pet, boolean bookable, int freeSeats, int price){
    	repository.save(new Trip(start,end,date,smoking,pet,bookable,freeSeats,price));
    }

    public void create (Trip trip){

       repository.save(trip);

    }
    public Collection<Trip> getAllTrips (){
        return repository.findAll();
    }
    public void delete (Long id){
        this.repository.deleteById(id);
    }
	@PostConstruct
	public void init() {
		if (repository.count() == 0) {
			createTripBySet("hh","hh","01.12.2018",false, false,false,12,12);


		}
	}
   /* public Trip findeById (Long id){
        return repository.findeById(id);
    }
    public Trip delete (Long id){
        return repository.deleteById(id);
    }
    public void addTripElement (Trip trip, TripElements tripElements){
        trip.getTripElementsList().add(tripElements);
    }*/
}
