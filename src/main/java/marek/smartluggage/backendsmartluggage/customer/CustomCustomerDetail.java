package marek.smartluggage.backendsmartluggage.customer;//package com.example.restfulsqlspringjpapostgres.customer;
/*
SmartLuggage Application
Marek Augustyn
12 May 2022
Final Project Software Developer
*/
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
////User details are build in Springboot security
////reference https://www.youtube.com/watch?v=tDZPdovCH4I
//public class CustomCustomerDetail implements UserDetails {
//    // this is from com.example.restfulsringjpaposgres not from a Spring
//    private Customer customer;
//
//    public CustomCustomerDetail(Customer customer) {
//        super();
//        this.customer = customer;
//    }
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//     return Collections.singleton(new SimpleGrantedAuthority(customer.getRole()));
//    }
//
//    @Override
//    public String getPassword() {
//        return customer.getCustomerPassword() ;
//    }
//
//    @Override
//    public String getUsername() {
//        return customer.getName();
//    }
//    //temporary true
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//    //temporary true
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//    //temporary true
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//    //temporary true
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
