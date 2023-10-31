package com.hello.spring.DI;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component // Spring이 Bean으로 만들어서 관리 의탁
public class Base64Encoder implements IEncoder{
    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
