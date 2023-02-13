package com.springboot.parkinglot.controller.sign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResultDto {

    private boolean success;

    private int code;

    private String msg;
}
