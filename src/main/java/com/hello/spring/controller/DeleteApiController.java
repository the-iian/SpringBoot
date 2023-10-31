package com.hello.spring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}") //http://localhost:8080/api/delete/100?account=user01
    public void delete(@PathVariable String userId, @RequestParam String account){

        System.out.println(userId);
        System.out.println(account);

        // delete 자체가 리소스 삭제이다.
        // 에러가 나더라도 에러대신 200ok를 던진다

    }
}
