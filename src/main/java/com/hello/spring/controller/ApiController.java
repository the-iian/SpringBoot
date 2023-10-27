package com.hello.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST API 처리하는 컨트롤러
@RequestMapping("/api") // URI를 지정해주는 어노테이션 (집주소)
public class ApiController {

    @GetMapping("/hello") // http://localhost:8080/api/hello 맵핑 (상세주소)
    public String hello(){
        return "hello spring boot!";

    }
}
