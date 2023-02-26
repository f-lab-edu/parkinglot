package com.springboot.parkinglot.controller.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private LoginUser loginUser;

    public UserPrincipal(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public static UserPrincipal create(LoginUser loginUser) {
        return new UserPrincipal(loginUser);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(this.loginUser.getRole());
        authorities.add(grantedAuthority);

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.loginUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.loginUser.getUsername();
    }

    //added
    public String getEmail() {
        return this.loginUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return loginUser.getActive().equals("1");
    }
}