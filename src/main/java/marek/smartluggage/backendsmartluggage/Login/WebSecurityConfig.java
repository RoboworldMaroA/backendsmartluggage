package marek.smartluggage.backendsmartluggage.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//this class allows crating security on the webapp
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

//    @Autowired
//    public WebSecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


//    @Bean
//    AuthenticationProvider authenticationProvider(){
//        //create Data access object
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        //password encoder
//         provider.setPasswordEncoder(new BCryptPasswordEncoder());
//         return  provider;
//    }

    //generate override method
    //everyone is permited to home page
    // To the User only autenticated user has access and to the Admin page as well
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              .csrf().disable()
              .cors().disable()
              .authorizeRequests()
              .antMatchers("/admin").hasRole("ADMIN")//to this link has acces only user that has a role Admin
              .antMatchers("/user").hasAnyRole("ADMIN", "USER")//to this has an access users with role Admin and User
              .antMatchers("/","/login","/addUser","/displayUsers","/displayUsers/*").permitAll()
//              .antMatchers("/api/v1/customer").hasAnyRole("USER", "ADMIN")
//              .antMatchers("/deleteUsers/**").hasAnyRole("USER","ADMIN")
//               .antMatchers("/api/v1/trip").permitAll()
              .antMatchers((HttpMethod.DELETE),"/api/v1/trip/*").hasRole("ADMIN")

              .antMatchers("/api/v1/customer").permitAll()
              .antMatchers("/deleteUsers/**").permitAll()
              .antMatchers("/api/v1/trip").permitAll()
//              .antMatchers("/api/v1/trip/*").permitAll()
//              .antMatchers("/displayUsers").hasRole("ADMIN")
//              .and().httpBasic().and().logout();

//
                .anyRequest().authenticated()
//              .and().httpBasic();
//              .and().formLogin();

                .and().formLogin().loginProcessingUrl("https://frontendsmartluggage.herokuapp.com/Login")
              .defaultSuccessUrl("https://frontendsmartluggage.herokuapp.com/",true).permitAll()
//                .failureForwardUrl("https://frontendsmartluggage.herokuapp.com/")
              .and().logout().permitAll()
              .and().httpBasic()
      ;


//              .authorizeRequests().antMatchers("http://localhost:8080/api/v1/**").permitAll().
//              antMatchers( "http://localhost:8080/Login").hasAuthority("USER").
//           antMatchers("http://localhost:8080/api/v1/trip").hasRole("ADMIN").
//              antMatchers("/api/v1/").permitAll().
//              antMatchers("/api/v1/trip/**").permitAll().
//              antMatchers("/api/v1/trip/").permitAll().
//              antMatchers("/api/v1/customer").permitAll().
//              antMatchers("/api/v1/customer/**").permitAll().
//              antMatchers("/").permitAll().
//              antMatchers("/customer/**").permitAll().
//              antMatchers("/trip/**").permitAll().
//              antMatchers("http://localhost:8080/api/v1/").permitAll().
//              antMatchers("http://localhost:8080/api/v1/trip/").permitAll().
//              antMatchers("http://localhost:8080/api/v1/customer").permitAll().
//              antMatchers("http://localhost:8080/api/v1/customer/**").permitAll().
//              antMatchers("http://localhost:8080/").permitAll().
//              antMatchers("http://localhost:8080/customer/**").permitAll().
//              antMatchers("http://localhost:8080/trip/**").permitAll().
//      anyRequest().authenticated().and().httpBasic()   ;



    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}




