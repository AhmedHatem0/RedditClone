package com.example.reddit.repository;


import com.example.reddit.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findByEmail(String email);
    Optional<MyUser> findByEmailAndActivationCode(String email, String activationCode);


}