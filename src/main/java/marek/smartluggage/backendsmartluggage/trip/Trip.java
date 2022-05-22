package marek.smartluggage.backendsmartluggage.trip;
/*
SmartLuggage Application
Marek Augustyn
12 May 2022
Final Project Software Developer
*/

//import com.example.restfulsqlspringjpapostgres.customer.Customer;
import marek.smartluggage.backendsmartluggage.customer.Customer;
import javax.persistence.*;
import java.time.LocalDate;

//Trip class with defined variables, constructor, setters and getters and override toString method

@Entity(name = "Trip")
@Table
public class Trip {

    //variable id is generated automatically
    @Id
    @SequenceGenerator(
            name = "trip_sequence",
            sequenceName = "trip_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trip_sequence"

    )

    @Column(name="id",
            updatable = false)
    private Long id;


    //variable trip name
    private String tripName;

//    @Column(
//            name = "customerId",
//            nullable = false,
//            columnDefinition = "TEXT"
//    )
//    private String customerId;

    @Column(
            name = "weatherId",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String weatherId;

//    @Id
//    @SequenceGenerator(
//            name = "listId_sequence",
//            sequenceName = "ListId_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "ListId_sequence"
//
//    )
    private String listId;
    private Boolean camera;
    private Boolean camcorder;
    private Boolean smartphone;
    private String ireland;
    private Boolean spain;
    private LocalDate departureDay;
    private LocalDate returnDay;
    private Boolean trekking;
    private String tripPassword;
    private String description;
    private Boolean adminPrivileges;
    private Boolean payStatus;
    private Boolean smallLuggage;
    private Boolean mediumLuggage;
    private Boolean largeLuggage;
    private Boolean plane;
    private Boolean beachListStatus;
    private Boolean bus;
    private Boolean train;
    private Boolean poland;
    private Boolean summer;
    private Boolean winter;
    private Boolean spring;
    private Boolean autumn;
    private Boolean car;
    private Boolean ski;
    private Boolean documentsListStatus;
    private Boolean essentialListStatus;
    private String destination;
    private Boolean female;
    private String sex;
    private Boolean laptop;
    private Boolean tablet;
    private Boolean drone;
    @Transient//this tell this colum (age) no need to be more in database table
    private Integer age;

    //empty constructor
    public Trip() {
    }


    //constructor
    public Trip(Long id, String tripName, String weatherId, String listId, Boolean camera, Boolean camcorder,
                Boolean smartphone, String ireland, Boolean spain, LocalDate departureDay,
                LocalDate returnDay, Boolean trekking, String tripPassword, String description,
                Boolean adminPrivileges, Boolean payStatus, Boolean smallLuggage, Boolean mediumLuggage,
                Boolean largeLuggage, Boolean plane, Boolean beachListStatus, Boolean bus, Boolean train,
                Boolean poland, Boolean summer,Boolean winter,Boolean spring,Boolean autumn,Boolean car,
                Boolean ski,  Boolean documentsListStatus, Boolean essentialListStatus, String destination,
                Boolean female, String sex, Boolean laptop, Boolean tablet, Boolean drone) {
        this.id = id;
        this.tripName = tripName;
        this.weatherId = weatherId;
        this.listId = listId;
        this.camera = camera;
        this.camcorder = camcorder;
        this.smartphone = smartphone;
        this.ireland = ireland;
        this.spain = spain;
        this.departureDay = departureDay;
        this.returnDay = returnDay;
        this.trekking = trekking;
        this.tripPassword = tripPassword;
        this.description = description;
        this.adminPrivileges = adminPrivileges;
        this.payStatus = payStatus;
        this.smallLuggage = smallLuggage;
        this.mediumLuggage = mediumLuggage;
        this.largeLuggage = largeLuggage;
        this.plane = plane;
        this.beachListStatus = beachListStatus;
        this.bus = bus;
        this.train = train;
        this.poland=poland;
        this.summer=summer;
        this.winter=winter;
        this.spring=spring;
        this.autumn=autumn;
        this.car=car;
        this.ski=ski;
        this.documentsListStatus=documentsListStatus;
        this.essentialListStatus=essentialListStatus;
        this.destination=destination;
        this.female=female;
        this.sex=sex;
        this.laptop=laptop;
        this.tablet=tablet;
        this.drone=drone;
        //this.age = age;
    }

    //constructor with auto generated  id
    public Trip( String tripName, String weatherId, String listId, Boolean camera, Boolean camcorder,
                 Boolean smartphone, String ireland, Boolean spain, LocalDate departureDay,
                 LocalDate returnDay, Boolean trekking, String tripPassword, String description,
                 Boolean adminPrivileges, Boolean payStatus, Boolean smallLuggage, Boolean mediumLuggage,
                 Boolean largeLuggage, Boolean plane, Boolean beachListStatus, Boolean bus, Boolean train,Boolean poland,
                 Boolean summer,Boolean winter,Boolean spring,Boolean autumn,Boolean car,Boolean ski,
                 Boolean documentsListStatus, Boolean essentialListStatus,String destination,Boolean female,
                 String sex, Boolean laptop, Boolean tablet,Boolean drone) {
        this.tripName = tripName;
        this.weatherId = weatherId;
        this.listId = listId;
        this.camera = camera;
        this.camcorder = camcorder;
        this.smartphone = smartphone;
        this.ireland = ireland;
        this.spain = spain;
        this.departureDay = departureDay;
        this.returnDay = returnDay;
        this.trekking = trekking;
        this.tripPassword = tripPassword;
        this.description = description;
        this.adminPrivileges = adminPrivileges;
        this.payStatus = payStatus;
        this.smallLuggage = smallLuggage;
        this.mediumLuggage = mediumLuggage;
        this.largeLuggage = largeLuggage;
        this.plane = plane;
        this.beachListStatus = beachListStatus;
        this.bus = bus;
        this.train = train;
        this.poland=poland;
        this.summer=summer;
        this.winter=winter;
        this.spring=spring;
        this.autumn=autumn;
        this.car=car;
        this.ski=ski;
        this.documentsListStatus=documentsListStatus;
        this.essentialListStatus=essentialListStatus;
        this.destination=destination;
        this.female=female;
        this.sex=sex;
        this.laptop=laptop;
        this.tablet=tablet;
        this.drone=drone;
        //this.age = age;
    }



    //Setters and getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public Boolean getCamera() {
        return camera;
    }

    public void setCamera(Boolean camera) {
        this.camera = camera;
    }

    public Boolean getCamcorder() {
        return camcorder;
    }

    public void setCamcorder(Boolean camcorder) {
        this.camcorder = camcorder;
    }

    public Boolean getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Boolean smartphone) {
        this.smartphone = smartphone;
    }

    public String getIreland() {
        return ireland;
    }

    public void setIreland(String ireland) {
        this.ireland = ireland;
    }

    public Boolean getSpain() {
        return spain;
    }

    public void setSpain(Boolean spain) {
        this.spain = spain;
    }

    public LocalDate getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(LocalDate departureDay) {
        this.departureDay = departureDay;
    }

    public LocalDate getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(LocalDate returnDay) {
        this.returnDay = returnDay;
    }

    public Boolean getTrekking() {
        return trekking;
    }

    public void setTrekking(Boolean trekking) {
        this.trekking = trekking;
    }

    public String getTripPassword() {
        return tripPassword;
    }

    public void setTripPassword(String tripPassword) {
        this.tripPassword = tripPassword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAdminPrivileges() {
        return adminPrivileges;
    }

    public void setAdminPrivileges(Boolean adminPrivileges) {
        this.adminPrivileges = adminPrivileges;
    }

    public Boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    public Boolean getSmallLuggage() {
        return smallLuggage;
    }

    public void setSmallLuggage(Boolean smallLuggage) {
        this.smallLuggage = smallLuggage;
    }

    public Boolean getMediumLuggage() {
        return mediumLuggage;
    }

    public void setMediumLuggage(Boolean mediumLuggage) {
        this.mediumLuggage = mediumLuggage;
    }

    public Boolean getLargeLuggage() {
        return largeLuggage;
    }

    public void setLargeLuggage(Boolean largeLuggage) {
        this.largeLuggage = largeLuggage;
    }

    public Boolean getPlane() {
        return plane;
    }

    public void setPlane(Boolean plane) {
        this.plane = plane;
    }

    public Boolean getBeachListStatus() {
        return beachListStatus;
    }

    public void setBeachListStatus(Boolean beachListStatus) {
        this.beachListStatus = beachListStatus;
    }

    public Boolean getBus() {
        return bus;
    }

    public void setBus(Boolean bus) {
        this.bus = bus;
    }

    public Boolean getTrain() {
        return train;
    }

    public void setTrain(Boolean train) {
        this.train = train;
    }

    public Boolean getPoland() {
        return poland;
    }

    public void setPoland(Boolean poland) {
        this.poland = poland;
    }

    public Boolean getSummer() {
        return summer;
    }

    public void setSummer(Boolean summer) {
        this.summer = summer;
    }

    public Boolean getWinter() {
        return winter;
    }

    public void setWinter(Boolean winter) {
        this.winter = winter;
    }

    public Boolean getSpring() {
        return spring;
    }

    public void setSpring(Boolean spring) {
        this.spring = spring;
    }

    public Boolean getAutumn() {
        return autumn;
    }

    public void setAutumn(Boolean autumn) {
        this.autumn = autumn;
    }

    public Boolean getCar() {
        return car;
    }

    public void setCar(Boolean car) {
        this.car = car;
    }

    public Boolean getSki() {
        return ski;
    }

    public void setSki(Boolean ski) {
        this.ski = ski;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getDocumentsListStatus() {
        return documentsListStatus;
    }

    public void setDocumentsListStatus(Boolean documentsListStatus) {
        this.documentsListStatus = documentsListStatus;
    }

    public Boolean getEssentialListStatus() {
        return essentialListStatus;
    }

    public void setEssentialListStatus(Boolean essentialListStatus) {
        this.essentialListStatus = essentialListStatus;
    }

    public Boolean getFemale() {
        return female;
    }

    public void setFemale(Boolean female) {
        this.female = female;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getLaptop() {
        return laptop;
    }

    public void setLaptop(Boolean laptop) {
        this.laptop = laptop;
    }

    public Boolean getTablet() {
        return tablet;
    }

    public void setTablet(Boolean tablet) {
        this.tablet = tablet;
    }

    public Boolean getDrone() {
        return drone;
    }

    public void setDrone(Boolean drone) {
        this.drone = drone;
    }

    //    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    //toString method
    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + Customer.class.getName() + '\'' +
                ", surname='" + weatherId + '\'' +
                ", email='" + listId + '\'' +
                ", dob=" + departureDay +
                ", age=" + age +
                ", age=" + trekking +
                '}';
    }
}///end class student
