package marek.smartluggage.backendsmartluggage.customer;
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

//this class is communicated with database but data is coming from the CustomerRepository Interface
@Service
public class CustomerService {
    //define variable customerRepository
    private final CustomerRepository customerRepository;

    //method CustomerService that take data from the Customer Repository
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //This method allow to get a data about customers -
    // it is taken data from the database using Customer Repository Interface
    //In Customer Repository is defined query to database
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
        //You can add hard coded data but instead of that this data will be in database
        // so this info we get this data from the interface and from the database
        //This is for Testing application only
//        return List.of(new Student(1L,
//                "Marek",
//                "Augustyn",
//                LocalDate.of(2000, Month.MAY,2),
//                21
//        ));
        }//end method getCustomer

    //method used to add new customer
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        //Testing only
        //System.out.println(customer);
        //instead of printing customer we want to save new customer
        customerRepository.save(customer);
    }

    //method used to delete customer from database
    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists){
            throw new IllegalStateException("`customer  with id: "+ customerId+" does not exist.");
        }
        //otherwise, - method deleteById is from SpringFramework
        customerRepository.deleteById(customerId);
    }


    //implementation PUT
    @Transactional
    public void updateCustomer(Long customerId,
                              String name,
                              String email) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new IllegalStateException(
                "Customer with id"+customerId+"dose not exist"));
        if (name != null && name.length()>0 && !Objects.equals(customer.getName(), name)){
            customer.setName(name);
        }
        //check email
        if (email != null && email.length()>0 && !Objects.equals(customer.getEmail(), email)){
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            if(customerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            customer.setEmail(email);
        }
    }//end update customer




    //implementation login
    //path is http://localhost:8080/api/v1/customer/login
    public void loginCustomers(String email, String password) {
        Optional<Customer> existedCustomerEmail = customerRepository.findCustomerByEmail(email);
        System.out.println(existedCustomerEmail);
    }


/*    public void verifyCustomerPassword(Customer customer, String email, String customer_password){
        Optional<Customer> verification = customerRepository.findCustomerByEmail(customer.getEmail());

        if (verification.isPresent()){
            throw new IllegalStateException("email is in database");
        }
        //instead of printing customer we want to save new customer

        //System.out.println(customer);
        customerRepository.getById(customer.getId()).toString();
    }*/


    //implement to display detail only one user that is registering (or when he is logged to his account)
    //i think that maybe i should do this in front end not back end??
    public List<Customer> getCustomerWithId(Long Id){
        boolean existCustomer = customerRepository.existsById(Id);
        if(!existCustomer){
            return (List<Customer>) customerRepository.getById(Id);
        }
        throw new IllegalStateException("No id have found");
    }






}
