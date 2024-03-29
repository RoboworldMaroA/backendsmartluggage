package marek.smartluggage.backendsmartluggage.Login;


import marek.smartluggage.backendsmartluggage.Login.model.User;
import marek.smartluggage.backendsmartluggage.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer > {
    @Query("SELECT s FROM Users s WHERE s.userName = ?1")
    Optional<User> findByUserName(String userName);

    List<User> findById(int id);

    @Query("SELECT s FROM Users s WHERE s.userEmail = ?1")
    Optional<User> findUserByUserEmail(String userEmail);

}
