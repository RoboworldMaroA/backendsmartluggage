package marek.smartluggage.backendsmartluggage.customer;//package com.example.restfulsqlspringjpapostgres.customer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import com.example.restfulsqlspringjpapostgres.customer.CustomerService.*;
//import java.util.Optional;
//
//@Service
//public class CustomCustomerDetailService implements UserDetailsService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        //Optional<Customer> customer = customerRepository.findByName( name);
//
//        Customer customer =customerRepository.findByName(name);
//        if (customer==null){
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new CustomCustomerDetail(customer);
//        //return (UserDetails) customerRepository.findAll();
//
//    }
//
////    //implementation services
////    public void deleteCustomer(Long customerId) {
////        boolean exists = customerRepository.existsById(customerId);
////        if (!exists){
////            throw new IllegalStateException("`customer  with id: "+ customerId+" does not exist.");
////
////        }
////        //otherwise
////        customerRepository.deleteById(customerId);
////    }
//
//
//
//
//
//}
