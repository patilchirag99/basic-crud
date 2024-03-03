package com.chirag.basiccrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    //Authentication
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("chirag")
                .password(passwordEncoder().encode("chirag"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,user);
       // return new UserInfoUserDetailsService();
    }

    //Authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/cloudvendor/home").permitAll()
                                .requestMatchers("/cloudvendor/admin/**").hasRole("ADMIN")
                                .requestMatchers("/cloudvendor/user").hasRole("USER")
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
