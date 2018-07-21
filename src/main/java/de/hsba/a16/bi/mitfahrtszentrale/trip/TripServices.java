package de.hsba.a16.bi.mitfahrtszentrale.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service
public class TripServices {
    private final TripRepository repository;


    public TripServices(TripRepository repository) {
        this.repository = repository;
    }
    @Autowired
    public Trip create (Trip trip){

       return repository.save(trip);

    }
    public Collection<Trip> getAllTrips (){
        return repository.findAll();
    }
    public void delete (Long id){
        this.repository.deleteById(id);
    }
    @PostConstruct
    public void init (){
        repository.deleteAll();
        if (repository.findAll().isEmpty())
        {
            /**
             *String start, String end, String date, boolean smoking, boolean pet, int freeSeats, int price
            */

            create(new Trip("Hamburg", "Lübeck", "101010", false, false, 12, 12)); create(new Trip("Hamburg", "Lübeck", "101010", false, false, 12, 12));


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
