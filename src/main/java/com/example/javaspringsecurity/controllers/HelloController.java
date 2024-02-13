package com.example.javaspringsecurity.controllers;

import com.example.javaspringsecurity.entities.MyUser;
import com.example.javaspringsecurity.repositories.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    MyUserRepo myUserRepo;

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
}
