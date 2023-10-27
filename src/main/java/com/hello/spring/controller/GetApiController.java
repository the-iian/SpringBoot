package com.hello.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello") // http://localhost:8080/api/get/hello 맵핑
    public String Hello(){
        return "get Hello";
    }

    // 구버전
    //@RequestMapping("/hi") // get, post, put, delete 모든 메서드가 동작함
    @RequestMapping(path="/hi", method = RequestMethod.GET) // 속성 get지정, http://localhost:8080/api/get/hi
    public String hi(){
        return "hi";

    }
}
