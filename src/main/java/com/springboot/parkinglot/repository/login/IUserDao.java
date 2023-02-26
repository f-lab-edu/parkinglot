package com.springboot.parkinglot.repository.login;

import com.springboot.parkinglot.controller.login.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserDao extends JpaRepository<LoginUser, String> {
    Optional<LoginUser> findByEmail(String email);
}
