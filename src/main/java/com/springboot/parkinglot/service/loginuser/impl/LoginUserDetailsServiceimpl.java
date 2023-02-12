package com.springboot.parkinglot.service.loginuser.impl;

import com.springboot.parkinglot.controller.login.LoginUserDetails;
import com.springboot.parkinglot.repository.loginuser.LoginUserRepository;
import com.springboot.parkinglot.service.loginuser.LoginUserDetailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class LoginUserDetailsServiceimpl implements LoginUserDetailService {


    private final Logger LOGGER = LoggerFactory.getLogger(LoginUserDetailsServiceimpl.class);
    private final LoginUserRepository loginUserRepository;

    @Override
    public LoginUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("[loadUserByUsername] loadUserByUsername 수행, username : {}",username);
        return loginUserRepository.getByUid(username);  //how to get by uid?
    }
}
