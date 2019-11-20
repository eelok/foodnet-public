package de.htw.foodnet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER = "USER";
    private static final String CHEF = "CHEF";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/images/*.jpg").permitAll()
            .antMatchers("/css/main.css").permitAll()
            .antMatchers("/about").permitAll()
            .antMatchers("/recipes/").hasAnyRole()
            .antMatchers(HttpMethod.GET, "/recipes/new").hasRole(CHEF)
            .antMatchers(HttpMethod.POST, "/recipes/new").hasRole(CHEF)
            .anyRequest().authenticated()
            .and()
            .formLogin();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails student =
                User.builder()
                        .username("student")
                        .password(passwordEncoder().encode("password"))
                        .roles(USER)
                        .build();
        UserDetails chef =
                User.builder()
                        .username("chef")
                        .password(passwordEncoder().encode("chef"))
                        .roles(CHEF)
                        .build();
        return new InMemoryUserDetailsManager(student, chef);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
