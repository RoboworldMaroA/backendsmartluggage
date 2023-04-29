package marek.smartluggage.backendsmartluggage.Login;


import marek.smartluggage.backendsmartluggage.Login.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.SEPTEMBER;


@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository){
        return args -> {
            User AdminMaro = new User(
                    "MaroAdmin",
                    "pass",
                    true,
                    "ROLE_ADMIN",
                    "Augustyn",
                    "JohnHays@o2.pl",
                    "1234567890",
                    LocalDate.of(1978, SEPTEMBER, 25),
                    "Dublin"


            );


            User UserMaro = new User(
                    "MaroUser",
                    "pass",
                    true,
                    "ROLE_USER",
                    "Augustyn",
                    "JohnHays@o2.pl",
                    "987654321",
                    LocalDate.of(2000, JANUARY, 1),
                    "Dublin"
            );

//            userRepository.saveAll(List.of(AdminMaro, UserMaro)
//                    );

            };



    }
}
