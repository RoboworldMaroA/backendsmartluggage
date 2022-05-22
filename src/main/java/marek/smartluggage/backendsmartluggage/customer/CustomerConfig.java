package marek.smartluggage.backendsmartluggage.customer;
/*
SmartLuggage Application
Marek Augustyn
12 May 2022
Final Project Software Developer
*/

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.SEPTEMBER;

//Customer Config class it creates tables in the database with the data inside Customer object

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunnerCustomer(CustomerRepository repository){

        return args -> {

            Customer Admin = new Customer(
                    //1l,
                    "John",
                    "Hays",
                    "JohnHays@o2.pl",
                    "1234567890",
                    LocalDate.of(1978, SEPTEMBER, 25),
                    "man",
                    "Dublin",
                    "$2a$12$OvkgfQ1WGolvCbR1F320reiei3cLQISxY6loU14kTVie/2ydo8gbS",
                    "1234",
                    "Yes",
                    "ADMIN",
                    true,
                    true

                    );



            Customer User = new Customer(
                    //1L, it will be generated
                    "Stephen",
                    "Gardiner",
                    "gardinen@wp.pl",
                    "1234567890",
                    LocalDate.of(2000, JANUARY, 20),
                    "man",
                    "Poland",
                    "password",
                    "password",
                    "No",
                    "USER",
                    false,
                    true

                    );

            Customer User3 = new Customer(
                    //1L, it will be generated
                    "Wiesiek",
                    "Augustyn",
                    "maugusty@o2.pl",
                    "1234567890",
                    LocalDate.of(2000, JANUARY, 20),
                    "man",
                    "Poland",
                    "pass",
                    "pass",
                    "Yes",
                    "USER",
                    true,
                    false

            );

            //now we tell that we want save customer using list
            repository.saveAll(
                    List.of(Admin, User, User3)

            );
        };


    }
}
