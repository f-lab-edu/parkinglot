package com.springboot.parkinglot.controller.login;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface LoginUserDetails extends Serializable {

    Collection<? extends GrantedAuthority> getAuthorities();    //GrantedAuthority?

    String getPassword();

    String getUsername();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
