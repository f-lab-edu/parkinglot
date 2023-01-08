package com.springboot.parkinglot.service.user.impl;

import com.springboot.parkinglot.controller.user.User;
import com.springboot.parkinglot.controller.user.UserDto;
import com.springboot.parkinglot.controller.user.UserResponseDto;
import com.springboot.parkinglot.repository.user.*;
import com.springboot.parkinglot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    private  final UserDao userDao;

    @Autowired
    public UserServiceimpl(UserDao userDao){this.userDao = userDao;}

    @Override
    public UserResponseDto saveUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());

        User savedUser = userDao.insertUser(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setNumber(savedUser.getNumber());
        userResponseDto.setId(savedUser.getId());
        userResponseDto.setPassword(savedUser.getPassword());
        userResponseDto.setName(savedUser.getName());

        return userResponseDto;
    }
}
