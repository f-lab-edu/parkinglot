package com.springboot.parkinglot.repository.login;

import com.springboot.parkinglot.controller.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserDao extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
