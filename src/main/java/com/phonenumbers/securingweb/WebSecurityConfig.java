package com.phonenumbers.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()//home page is open for everyone
                .antMatchers("/company/1/*").hasRole("1")//Only user with role "1" can see /company/1/* pages
                .antMatchers("/company/2/*").hasRole("2")//Only user with role "2" can see /company/2/* pages
                .and()
                .formLogin()
                .loginPage("/")
                .permitAll();//Home page is a login page and available for everyone
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        /*This code can only be used for demonstration
        * */
        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("Ivan")
                        .password("password")
                        .roles("1")
                        .build();

        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("Denis")
                        .password("password")
                        .roles("2")
                        .build();
        ArrayList<UserDetails> user=new ArrayList<>();
        user.add(user1);
        user.add(user2);
        return new InMemoryUserDetailsManager(user);
    }
}
