package com.example.javaspringsecurity.repositories;

import com.example.javaspringsecurity.entities.MyAuthorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAuthorityRepo extends JpaRepository<MyAuthorities, Long> {
}
