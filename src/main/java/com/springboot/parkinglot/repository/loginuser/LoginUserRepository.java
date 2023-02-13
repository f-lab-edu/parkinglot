package com.springboot.parkinglot.repository.loginuser;

import com.springboot.parkinglot.controller.login.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    LoginUser getByUid(String uid);
}
