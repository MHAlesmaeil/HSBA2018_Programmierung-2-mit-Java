package de.hsba.a16.bi.mitfahrtszentrale.trip;

import de.hsba.a16.bi.mitfahrtszentrale.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TripRepository extends JpaRepository<Trip, Long> {

	@Query("select distinct j from Trip j where j.owner= :user")
	List<Trip> findAllByOwnedByCurrentUser(@Param("user") User user);
}
