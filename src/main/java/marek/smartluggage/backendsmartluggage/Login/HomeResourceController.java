package marek.smartluggage.backendsmartluggage.Login;


import marek.smartluggage.backendsmartluggage.Login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"https://smartluggage.herokuapp.com","https://localhost:3000","https://smartluggage-ijzs3.ondigitalocean.app","https://marekaugustyn.whshost.com","https://smartluggage2023.ew.r.appspot.com"})
@RestController
@RequestMapping
public class HomeResourceController {

    private final MyUserDetailService myUserDetailService;

    @Autowired
    public HomeResourceController(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }


    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }


    //printing list of the users GET method
    @GetMapping("/displayUsers")
    public List<User> getUsers() {
        return myUserDetailService.getUsers();
    }


    //printing list of the users GET method
    @GetMapping("/displayUsers/{id}")
    public List<User> getUsers(@PathVariable int id) {
        return myUserDetailService.getUsersById(id);
    }

    @PostMapping("/addUser")
    public void registerNewUser(@RequestBody User user) {
        myUserDetailService.addNewUser(user);
    }//end POST


    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody User user) throws Exception {

        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));

            System.out.println("This is authentication object" + authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials");
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }


    //**********   DELETE     *******************************************
    @DeleteMapping(path = "/deleteUsers/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        myUserDetailService.deleteUser(id);
    }

    //**********   PUT      *******************************************
    // put update data in the customer for example we want ot change name and email
    @PutMapping(path= "/updateUsers/{id}")
    public void updateUser(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String userEmail
    ){
        myUserDetailService.updateUsers(id,userName,userEmail);
    }

    //**********   PUT      *******************************************
    // put update data in the customer for example we want ot change name and email
    @PostMapping(path= "/deleteUsers/{id}")
    public void updateUser2(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String userEmail
    ){
        myUserDetailService.updateUsers(id,userName, userEmail);
    }

}
