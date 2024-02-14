package com.example.javaspringsecurity.configs;

import com.example.javaspringsecurity.entities.MyUser;
import com.example.javaspringsecurity.repositories.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    MyUserRepo myUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = myUserRepo.findById(username);
        user.orElseThrow();
        return new MyUserDetails(user.get());
    }
}
