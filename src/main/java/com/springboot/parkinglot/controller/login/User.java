package com.springboot.parkinglot.controller.login;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Getter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String username;
    private String password;
    private String email;  // user를 찾을 때 email을 이용하여 찾는다.
    private String active; // 1: active, 0: inactive
    private String role;

    @Builder
    public User(String username, String password, String email, String active, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
        this.role = role;
    }
}
