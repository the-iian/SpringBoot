package com.hello.spring.DI;

import org.springframework.beans.factory.annotation.Qualifier;

public class Encoder{

    private IEncoder iEncoder;

    public Encoder(@Qualifier("urlEncoder") IEncoder iEncoder){
        // this.iEncoder = new Base64Encoder();
        // this.iEncoder = new UrlEncoder();
           this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder){
        this.iEncoder = iEncoder;
    }

    public String encode(String message){
        return iEncoder.encode(message);
    }
}
