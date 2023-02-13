package com.springboot.parkinglot.service.loginuser;

import com.springboot.parkinglot.controller.login.LoginUserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginUserDetailService {

    LoginUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
