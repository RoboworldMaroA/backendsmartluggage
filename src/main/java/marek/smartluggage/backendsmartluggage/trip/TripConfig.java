package marek.smartluggage.backendsmartluggage.trip;
/*
SmartLuggage Application
Marek Augustyn
12 May 2022
Final Project Software Developer
*/
//create a bean

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.AUGUST;
import static java.time.Month.OCTOBER;


//TRIP CONFIG CLASS USED TO CREATE TABLE IN DATABASE AND SAVE DATA WITH TRIP DETAILS IN THE COLUMNS
@Configuration
public class TripConfig {
    @Bean
    CommandLineRunner commandLineRunnerTrip(TripRepository tripRepository){
        return args -> {
            Trip TripToSpain = new Trip(
                    //,
                    "Trip To Spain",
                    "Whether list 1",
                    "List ID 1",
                    true,
                    false,
                    true,
                    "0",
                    true,
                    LocalDate.of(2022, AUGUST, 10),
                    LocalDate.of(2022,AUGUST,20),
                    false,
                    "password",
                    "Beach and leisure.",
                    true,
                    false,
                    true,
                    true,
                    true,
                    true,
                    true,
                    true,
                    true,
                    false,
                    true,
                    false,
                    false,
                    false,
                    true,
                    true,
                    true,
                    true,
                    "Spain",
                    true,
                    "male",
                    true,
                    true,
                    true
            );


            Trip TripToIreland = new Trip(
                    //,
                    "Trip to Ireland",
                    "list 2",
                    "interesting list change this",
                    true,
                    true,
                    true,
                    "1",
                    false,
                    LocalDate.of(2022, OCTOBER, 10),
                    LocalDate.of(2022,OCTOBER,20),
                    true,
                    "password",
                    "Beach, and rest with wife. This Customer has paid subscription",
                    true,
                    true,
                    true,
                    true,
                    true,
                    true,
                    true,
                    true,
                    true,
                    false,
                    false,
                    false,
                    false,
                    false,
                    true,
                    true,
                    true,
                    true,
                    "Ireland",
                    false,
                    "female",
                    true,
                    true,
                    true

                    );



            //now we tell that we want save customer using list
            tripRepository.saveAll(
//                    List.of(TripToIreland, TripToSpain)
                    List.of(TripToSpain)

            );
        };


    }
}
