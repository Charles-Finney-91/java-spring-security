package com.example.javaspringsecurity.configs;

import com.example.javaspringsecurity.entities.MyUser;
import com.example.javaspringsecurity.repositories.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Optional;

@Configuration
@Profile("jpa")
public class JpaSecConfig {
    @Autowired
    MyUserRepo myUserRepo;

    @Autowired
    public void insertData(){
        myUserRepo.saveAllAndFlush(
                List.of(
                        new MyUser("user", "pass", "ROLE_USER", (byte) 1),
                        new MyUser("admin", "pass", "ROLE_ADMIN", (byte) 1)
                )
        );
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            Optional<MyUser> user = myUserRepo.findById(username);
            user.orElseThrow();
            return new MyUserDetails(user.get());
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth.requestMatchers("/").permitAll()
                        .requestMatchers("/user").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }
}
