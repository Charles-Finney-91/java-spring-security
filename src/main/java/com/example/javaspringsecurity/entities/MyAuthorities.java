package com.example.javaspringsecurity.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MyAuthorities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authority;
    @ManyToOne
    @JoinColumn(name = "myUser_username")
    private MyUser myUser;

    public MyAuthorities(String authority) {
        this.authority = authority;
    }
}
