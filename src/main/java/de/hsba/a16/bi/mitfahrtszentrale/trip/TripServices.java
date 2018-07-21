package de.hsba.a16.bi.mitfahrtszentrale.trip;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service
public class TripServices {
    private final TripRepository repository;


    public TripServices(TripRepository repository) {
        this.repository = repository;
    }
    public Trip create (String name){
        Trip trip = new Trip(name);

       return repository.save(trip);

    }
    public Collection<Trip> getAllTrips (){
        return repository.findAll();
    }
    @PostConstruct
    public void init (){
        repository.deleteAll();
        if (repository.findAll().isEmpty())
        {

            create("something");create("something");create("something");create("something");create("something");

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
