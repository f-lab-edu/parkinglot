package com.springboot.parkinglot.controller.user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
//@AllArgsConstructor
@Data
public class UserDto {

    private String id;

    private String password;

    private String name;

    public UserDto(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
