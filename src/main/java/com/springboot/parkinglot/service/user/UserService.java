package com.springboot.parkinglot.service.user;

import com.springboot.parkinglot.controller.user.UserDto;
import com.springboot.parkinglot.controller.user.UserResponseDto;

public interface UserService {

    UserResponseDto saveUser(UserDto userDto);
}
