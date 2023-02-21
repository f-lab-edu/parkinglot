package com.springboot.parkinglot.service.login;

import com.springboot.parkinglot.controller.login.LoginUser;
import com.springboot.parkinglot.controller.login.UserPrincipal;
import com.springboot.parkinglot.repository.login.IUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final IUserDao iUserDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        LoginUser loginUser = iUserDao.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email"));

        return UserPrincipal.create(loginUser);
    }
}
