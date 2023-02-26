package com.springboot.parkinglot.controller.login;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    @GetMapping("/api/v1/login") // admin 권한에게만
    public String login() {

        return "Success ADMIN";
    }

    @GetMapping("/api/v1/login2") // manager 권한에게만
    public String login2() {

        return "Success MANAGER";
    }
}
