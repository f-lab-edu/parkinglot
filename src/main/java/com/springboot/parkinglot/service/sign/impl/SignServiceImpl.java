package com.springboot.parkinglot.service.sign.impl;

import com.springboot.parkinglot.controller.sign.SignInResultDto;
import com.springboot.parkinglot.controller.sign.SignUpResultDto;
import com.springboot.parkinglot.service.sign.SignService;

public class SignServiceImpl implements SignService {
    @Override
    public SignUpResultDto signUp(String id, String password, String name, String role) {
        return null;
    }

    @Override
    public SignInResultDto signIn(String id, String password) throws RuntimeException {
        return null;
    }
}
