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
@AllArgsConstructor
@ToString
public class MyUser {
    @Id
    private String username;
    private String password;
    private String authority;
    private byte enabled;
}
