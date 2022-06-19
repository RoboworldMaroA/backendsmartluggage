package marek.smartluggage.backendsmartluggage.Login.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="Users")
//@Table(name="User", schema = "public")
//@Table(schema = "users_sequence")
@Table
public class User {

    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
@Id
@GeneratedValue(
            strategy = GenerationType.SEQUENCE
            ,
            generator = "users_sequence"
    )
    @Column(name="id",
            updatable = false)
    public int id;

    private String userName;
    private  String password;
    private boolean active;
    private String roles ;

    private String userSurname;
    private String userEmail;
    private String userPhoneNumber;
    private LocalDate userDob;
    private String userAddress;


    public User() {
    }

    public User(String userName, String password, boolean active,
                String roles, String userSurname, String userEmail, String userPhoneNumber,
                LocalDate userDob,String userAddress) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.userSurname=userSurname;
        this.userEmail=userEmail;
        this.userPhoneNumber=userPhoneNumber;
        this.userDob=userDob;
        this.userAddress=userAddress;

    }

//    public int getId() {
//        return id;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public LocalDate getUserDob() {
        return userDob;
    }

    public void setUserDob(LocalDate userDob) {
        this.userDob = userDob;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userDob=" + userDob +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
