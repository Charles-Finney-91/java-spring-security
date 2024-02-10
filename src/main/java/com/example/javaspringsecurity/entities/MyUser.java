package com.example.javaspringsecurity.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
public class MyUser {
    @Id
    private String username;
    private String password;
    private byte enabled;
    @OneToMany(
            mappedBy = "myUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MyAuthorities> authorities;

    public MyUser(String username, String password, byte enabled, List<MyAuthorities> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }
}
