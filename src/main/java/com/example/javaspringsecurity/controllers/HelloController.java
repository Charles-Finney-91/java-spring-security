package com.example.javaspringsecurity.controllers;

import com.example.javaspringsecurity.entities.MyAuthorities;
import com.example.javaspringsecurity.entities.MyUser;
import com.example.javaspringsecurity.repositories.MyAuthorityRepo;
import com.example.javaspringsecurity.repositories.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    MyUserRepo myUserRepo;
    @Autowired
    MyAuthorityRepo myAuthorityRepo;

    @GetMapping("/")
    public String home(){
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>Welcome Admin</h1>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h1>Welcome User</h1>";
    }

    @GetMapping("/repo-insert")
    public void repoInsert(){
        myUserRepo.saveAllAndFlush(
                List.of(
                        new MyUser("user", "pass", (byte) 1, List.of(new MyAuthorities("ROLE_USER"))),
                        new MyUser("admin", "pass", (byte) 1, List.of(new MyAuthorities("ROLE_ADMIN")))
                )
        );

        myUserRepo.findAll().forEach(System.out::println);

        myAuthorityRepo.findAll().forEach(System.out::println);
    }
}
