package com.example.javaspringsecurity.configs;

import com.example.javaspringsecurity.entities.MyUser;
import com.example.javaspringsecurity.repositories.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("h2-data-seed")
public class H2DataSeedConfig {
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
}
