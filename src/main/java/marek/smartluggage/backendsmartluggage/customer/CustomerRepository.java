package marek.smartluggage.backendsmartluggage.customer;
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

//Customer Repository interface used to set a query to database

//import for communication 3000 port and 8080
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//responsible for data access they are extends to the JpaRepository
// which allows finding customers using email
@Repository
public interface  CustomerRepository
        extends JpaRepository<Customer, Long> {//customer class and long because ID is long

    //we want to find customer using specific email - to do that we have can use Optional imported from Java package

    @Query("SELECT s FROM Customer s WHERE s.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);


    @Query("SELECT s FROM Customer s WHERE s.name = ?1")
    //Optional <Customer> findByName(String name);
     Customer findByName(String name);
}
