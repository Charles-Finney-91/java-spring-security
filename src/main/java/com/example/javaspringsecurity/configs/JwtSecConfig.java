package com.example.javaspringsecurity.configs;

import com.example.javaspringsecurity.entities.MyUser;
import com.example.javaspringsecurity.filters.JwtAuthFilter;
import com.example.javaspringsecurity.repositories.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Optional;

@Configuration
@Profile("jwt")
public class JwtSecConfig {

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // disabling csrf
        http.csrf().disable();

        // setting up api wise authorization
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers("/generateToken").permitAll()
                        .anyRequest().authenticated()
        );

        // disabling default session management
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // including the JWT aut filter for enabling JWT process
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
