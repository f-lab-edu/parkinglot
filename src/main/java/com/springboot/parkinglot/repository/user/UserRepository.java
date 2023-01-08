package com.springboot.parkinglot.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.parkinglot.controller.user.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
