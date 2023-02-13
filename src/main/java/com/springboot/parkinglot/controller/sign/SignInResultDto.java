package com.springboot.parkinglot.controller.sign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignInResultDto extends SignUpResultDto{

    private String token;

    @Builder
    public SignInResultDto(boolean sucess, int code, String msg, String token){
        super(sucess, code, msg);
        this.token = token;
    }
}
