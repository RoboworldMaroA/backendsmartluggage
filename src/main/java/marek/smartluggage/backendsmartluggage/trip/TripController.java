package marek.smartluggage.backendsmartluggage.trip;
/*
SmartLuggage Application
Marek Augustyn
12 May 2022
Final Project Software Developer
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// in this class we implement GET, POST,PUT, DELETE
//this is a proper way we could have rst controller in main restfull app but
// this is good practice do this that way
@CrossOrigin(origins = "https://frontendsmartluggage.herokuapp.com/")

@RestController
@RequestMapping(path = "/api/v1/trip")
//@CrossOrigin(origins = "http://localhost:3000")
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        //this.studentService = new StudentService();//this is incorrect so use annotation to inject student service
        this.tripService = tripService;
    }

    //printing list of the students GET method
    @GetMapping
    public List<Trip> getTrip() {

        //THIS IS FOR TEST ONLY
//            return List.of(new Student(1L,
//                    "Marek",
//                    "Augustyn",
//                    LocalDate.of(2000, Month.MAY,2),
//                    21

//
//                    ));

        return tripService.getTrip();
    }

    //implementation post
    // add new student
    //request body is an element student with details

    //**********   POST *******************************************
    @PostMapping
    public void registerNewTrip(@RequestBody Trip trip) {
        tripService.addNewTrip(trip);
    }//end POST


    //**********   DELETE     *******************************************
    @DeleteMapping(path = "{tripId}")
    public void deleteTrip(@PathVariable("tripId") Long Id) {
        tripService.deleteTrip(Id);
    }



    //**********   PUT      *******************************************
    // put update data in the student for example we want ot change name and email
    @PutMapping(path = "{tripId}")
    public void updateTrip(
            @PathVariable("tripId") Long tripId,
            @RequestParam(required = false) String tripName
            //@RequestParam(required = false) String listId

    ) {
//        tripService.updateTrip(tripId,name,listId);
        tripService.updateTrip(tripId, tripName);
    }



    //************** Login verification *****************
/*
    @PostMapping
    public void verificationCustomerLogin(@RequestBody Customer customer, String email, String customerPassword){
        customerService.verifyCustomerPassword(customer,email, customerPassword);
    }*/

}
