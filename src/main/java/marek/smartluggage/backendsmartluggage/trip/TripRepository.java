package marek.smartluggage.backendsmartluggage.trip;
/*
SmartLuggage Application
Marek Augustyn
12 May 2022
Final Project Software Developer
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//responsible for data access from database
@Repository
public interface TripRepository
        extends JpaRepository<Trip, Long> {//customer class and long because ID is long

    //we want to find customer using specific email - to do that we have can use Optional imported from Java package
    @Query("SELECT s FROM Trip s WHERE s.tripName = ?1")
    Optional<Trip> findTripByTripName(String tripName);

}
