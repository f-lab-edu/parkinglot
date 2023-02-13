package com.springboot.parkinglot.service.sign.impl;

import com.springboot.parkinglot.config.security.JwtTokenProvider;
import com.springboot.parkinglot.controller.login.LoginUser;
import com.springboot.parkinglot.controller.sign.SignInResultDto;
import com.springboot.parkinglot.controller.sign.SignUpResultDto;
import com.springboot.parkinglot.repository.loginuser.LoginUserRepository;
import com.springboot.parkinglot.service.sign.SignService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SignServiceImpl implements SignService {

    public LoginUserRepository loginUserRepository;
    public JwtTokenProvider jwtTokenProvider;
    public PasswordEncoder passwordEncoder; //what?


    @Override
    public SignUpResultDto signUp(String id, String password, String name, String role) {

        LoginUser loginUser;

        //role에 따른 roles 주입
        if(role.equals("admin")){
            loginUser = LoginUser.builder()
                    .uid(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .roles(Collections.singletonList("ROLE_ADMIN"))
                    .build();
        } else {
            loginUser = LoginUser.builder()
                    .uid(id)
                    .name(name)
                    .password(passwordEncoder.encode(password))
                    .roles(Collections.singletonList("ROLE_USER"))
                    .build();
        }

        //DB 저장
        LoginUser savedLoginUser = loginUserRepository.save(loginUser);

        //return 처리
        SignUpResultDto signUpResultDto = new SignUpResultDto();

        if(!savedLoginUser.getName().isEmpty()){
            setSuccesResult(signUpResultDto);
        } else{
            setFailResult(signUpResultDto);
        }
        return signUpResultDto;
    }

    @Override
    public SignInResultDto signIn(String id, String password) throws RuntimeException {

        LoginUser loginUser = loginUserRepository.getByUid(id);

        //pw 불일치 시
        if(!passwordEncoder.matches(password, loginUser.getPassword())){
            throw new RuntimeException();
        }

        //return 처리
        SignInResultDto signInResultDto = SignInResultDto.builder()
                .token(jwtTokenProvider.createToken(String.valueOf(loginUser.getUid()),
                        loginUser.getRoles()))
                .build();

        setSuccesResult(signInResultDto);

        return signInResultDto;
    }

    private void setFailResult(SignUpResultDto result) {
        result.setSuccess(true);
        result.setCode(0);
        result.setMsg("Success");
    }

    private void setSuccesResult(SignUpResultDto result) {
        result.setSuccess(false);
        result.setCode(-1);
        result.setMsg("Fail");
    }
}
