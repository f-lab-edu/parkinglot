package com.springboot.parkinglot.controller.user;

import com.springboot.parkinglot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private  final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> createUserRequest(@RequestBody UserDto userDto){
        UserResponseDto userResponseDto = userService.saveUser(userDto);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @GetMapping()
    public  ResponseEntity<UserResponseDto> getUserRequest(Long number){
        UserResponseDto userResponseDto = userService.getUser(number);

        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
}