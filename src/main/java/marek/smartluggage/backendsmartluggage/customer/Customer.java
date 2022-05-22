package marek.smartluggage.backendsmartluggage.customer;
/*
SmartLuggage Application
Marek Augustyn
12 May 2022
Final Project Software Developer
*/


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//Customer clas with declared variables in the customer object, constructor, setters and getters

@Entity(name = "Customer")
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(name="id",
            updatable = false)
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "surname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String surname;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    private String phoneNumber;
    private LocalDate dob;
    private String sex;
    private String address;
    private String customerPassword;
    private String customerPasswordAgain;
    private String adminPrivileges;
    private String role;

    @Transient//this tell this colum (age) no need to be more in database table
    private Integer age;
    private Boolean documentsList;
    private Boolean beachList;


    //empty constructor
    public Customer() {
    }


    //constructor with id not automatic generated
    public Customer(Long id, String name, String surname, String email, String phoneNumber, LocalDate dob, String sex, String address, String customerPassword, String customerPasswordAgain, String adminPrivileges,String role, Boolean documentsList,Boolean beachList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.sex = sex;
        this.address=address;
        this.customerPassword = customerPassword;
        //this.age = age;
        this.customerPasswordAgain = customerPasswordAgain;
        this.adminPrivileges= adminPrivileges;
        this.role= role;
        this.documentsList=documentsList;
        this.beachList=beachList;
    }

    //constructor without id because it will automatically create id for us
    public Customer(String name, String surname, String email, String phoneNumber, LocalDate dob, String sex,
                    String address,String customerPassword, String customerPasswordAgain, String adminPrivileges,String role,
                    Boolean documentsList, Boolean beachList) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.sex = sex;
        this.address=address;
        this.customerPassword = customerPassword;
        this.customerPasswordAgain = customerPasswordAgain;
        this.adminPrivileges= adminPrivileges;
        this.role= role;
        this.documentsList=documentsList;
        this.beachList=beachList;
    }


    //Setters and Getters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminPrivileges() {
        return adminPrivileges;
    }

    public void setAdminPrivileges(String adminPrivileges) {
        this.adminPrivileges = adminPrivileges;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCustomerPasswordAgain() {
        return customerPasswordAgain;
    }

    public void setCustomerPasswordAgain(String customerPasswordAgain) {
        this.customerPasswordAgain = customerPasswordAgain;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String password) {
        this.customerPassword = password;
    }

    //    public Integer getAge() {
//        return age;
//    }
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Boolean getDocumentsList() {
        return documentsList;
    }

    public void setDocumentsList(Boolean documentsList) {
        this.documentsList = documentsList;
    }

    public Boolean getBeachList() {
        return beachList;
    }

    public void setBeachList(Boolean beachList) {
        this.beachList = beachList;
    }


    //override toString method used to print data in the customer object
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", age=" + address +
                '}';
    }
}///end class student
