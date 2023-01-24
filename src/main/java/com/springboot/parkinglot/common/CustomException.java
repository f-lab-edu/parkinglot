package com.springboot.parkinglot.common;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CustomException extends Exception{

    CustomException(String messsage){
        super(messsage);
    }
}
