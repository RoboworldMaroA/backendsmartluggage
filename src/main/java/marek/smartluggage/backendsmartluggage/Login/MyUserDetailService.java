package marek.smartluggage.backendsmartluggage.Login;


import marek.smartluggage.backendsmartluggage.Login.model.MyUserDetails;
import marek.smartluggage.backendsmartluggage.Login.model.User;
import marek.smartluggage.backendsmartluggage.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class MyUserDetailService implements UserDetailsService {


//    @Autowired
//    UserRepository userRepository;

    private static  UserRepository userRepository;

    @Autowired
    public MyUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    //implementation delete service
    //method used to delete customer from database
    public static void deleteUser(Integer id) {
        boolean exists = userRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("`customer  with id: "+ id+" does not exist.");
        }
        //otherwise, - method deleteById is from SpringFramework
        System.out.println("I am in user detail service in method deleteUser by ID. Id is: "+id);
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }

    //get all user data used to login
    public List<User> getUsers() {
        return userRepository.findAll();

    }


    //method used to add new customer that is checking a unique name
    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findByUserName(user.getUserName());
        if (userOptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        //Testing only
        //System.out.println(customer);
        //instead of printing customer we want to save new customer
        userRepository.save(user);
    }


    //implementation PUT
    @Transactional
    public void updateUsers(Integer id,
                               String userName, String userEmail) {
         User userUpdate = userRepository.findById(id).orElseThrow(()-> new IllegalStateException(
                "Customer with id "+id+" does not exist!"));
        if (userName != null && userName.length()>0 && !Objects.equals(userUpdate.getUserName(), userName)){
            System.out.println("Hi I am in the update Users and I should update a name");
            userUpdate.setUserName(userName);
            System.out.println("After update name is: "+userUpdate.getUserName());
        }
//        check email
        if (userEmail != null && userEmail.length()>0 && !Objects.equals(userUpdate.getUserEmail(), userEmail)){
            Optional<User> userOptional = userRepository.findCustomerByUserEmail(userEmail);
            if(userOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            userUpdate.setUserEmail(userEmail);

            System.out.println("After update email is: "+userUpdate.getUserEmail());
        }
    }//end update customer


    public List<User> getUsersById(int id) {
        return userRepository.findById(id);
    }
}
