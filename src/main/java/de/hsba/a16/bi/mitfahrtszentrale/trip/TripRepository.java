package de.hsba.a16.bi.mitfahrtszentrale.trip;

import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class TripRepository {
  private Map<Long, Trip> store= new TreeMap<>();

  private long id;
  private synchronized Long nextId (){
      return ++id;
  }

  public Trip saveTrip (Trip trip){
      Long id = nextId();
      trip.setId(id);
      store.put(id, trip);
      return trip;
  }
  public Collection<Trip> findAll (){
      return store.values();
  }
  public Trip findeById (Long id){
      return store.get(id);
  }
    public Trip deleteById (Long id){
        return store.remove(id);
    }
}
