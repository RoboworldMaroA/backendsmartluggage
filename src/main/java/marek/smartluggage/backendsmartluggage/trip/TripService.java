package marek.smartluggage.backendsmartluggage.trip;
/*
SmartLuggage Application
Marek Augustyn
12 May 2022
Final Project Software Developer
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
//this is class where are implemented services used to read, add, delete and update Trip data,
@Service
public class TripService {
    //define variable customerRepository
    private final TripRepository tripRepository;

    //method CustomerService
    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getTrip(){
        return tripRepository.findAll();
        }//end method getTrip


//    implementation add trip to database service
    public void addNewTrip(Trip trip) {
        Optional<Trip> tripOptional = tripRepository.findTripByTripName(trip.getTripName());

        if (tripOptional.isPresent()) {
            throw new IllegalStateException("Trip with that name is existing change the name please!");
        }
        //System.out.println(trip);//For Testing Only

        //instead of printing trip we want to save new trip
        System.out.println("I am in trip service in method addNewTrio. Trip name is: "+trip.getTripName());
        tripRepository.save(trip);
    }


    //implementation delete service
    public void deleteTrip(Long tripId) {
        boolean exists = tripRepository.existsById(tripId);
        if (!exists){
            throw new IllegalStateException("Trip  with id: "+ tripId+" does not exist.");
        }
        //otherwise
        System.out.println("I am in trip service in method deleteTrip by ID. Trip id is: "+tripId);
        tripRepository.deleteById(tripId);
    }



    //implementation PUT
    @Transactional
    public void updateTrip(Long tripId,
                               String tripName) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new IllegalStateException(
                "Trip with id" + tripId + "dose not exist"));
        if (tripName != null && tripName.length() > 0 && !Objects.equals(trip.getTripName(), tripName)) {
            trip.setTripName(tripName);
        }
        //check email

//        if (email != null && email.length()>0 && !Objects.equals(customer.getEmail(), email)){
//            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
//            if(customerOptional.isPresent()){
//                throw new IllegalStateException("email taken");
//            }
//            customer.setEmail(email);
  //   }

    }//end update Trip


}
