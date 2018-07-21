package de.hsba.a16.bi.mitfahrtszentrale.trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
