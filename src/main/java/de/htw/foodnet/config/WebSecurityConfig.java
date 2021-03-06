package de.htw.foodnet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER = "USER";
    private static final String CHEF = "CHEF";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/recipes/photo/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/images/*.jpg").permitAll()
                .antMatchers("/css/main.css").permitAll()
                .antMatchers("/about").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/recipes").hasAuthority(USER)
                .antMatchers("/recipes/new").hasAuthority(CHEF)
                .anyRequest()
                .authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()
            .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll()
            ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
