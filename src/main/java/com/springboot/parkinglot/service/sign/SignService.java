package com.springboot.parkinglot.service.sign;

import com.springboot.parkinglot.controller.sign.SignInResultDto;
import com.springboot.parkinglot.controller.sign.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String role);   //회원 가입

    SignInResultDto signIn(String id, String password) throws RuntimeException; //로그인
}
