package com.example.javaspringsecurity.repositories;

import com.example.javaspringsecurity.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, String> {
}
