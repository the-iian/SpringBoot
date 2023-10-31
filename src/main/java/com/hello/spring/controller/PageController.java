package com.hello.spring.controller;

import com.hello.spring.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // html 페이지를 리턴하는 controller
public class PageController {

    @RequestMapping("/main") // http://localhost:8080/main
    public String main(){
    // 리턴자체가 String이면 자동으로 리소스에 있는 html 파일을 찾아간다

        return "main.html";
    }

    // ResponseEntity
    // RestAPI를 주로 사용해서 따로 page controller는 잘 사용하지않지만, 혹시나 내려야한다고하면 사용하는 방식
    @ResponseBody
    @GetMapping("/user") // http://localhost:8080/user
    public User user(){

        var user = new User();
        // Java11ver.부터 추가된 타입을 추론하는 방법 (단축된 약어)
        // User user = new User(); - 구버전

        user.setName("steve");
        user.setAddress("패스트 캠퍼스");

        return user;
    }
}
