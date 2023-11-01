package com.hello.spring.controller;

import com.hello.spring.annotation.Decode;
import com.hello.spring.annotation.Timer;
import com.hello.spring.dto.Member;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}") // http://localhost:8080/api/get/100?name=steve
    public String get(@PathVariable Long id, @RequestParam String name){

    //  System.out.println("get method");
    //  System.out.println("get method : " + id);
    //  System.out.println("get method : " + name);
    //  AOP 메소드 이름 출력을 통해 Systemout에 직접 찍을 필요없이 디버깅이 가능해진다

        return id + " " + name;
    }

    @PostMapping("/post2") // http://localhost:8080/api/post2
    public Member post(@RequestBody Member member){

     // System.out.println("post method : " + member);

        return member;
    }


    @Timer // 시간 측정
    @DeleteMapping("/delete") // http://localhost:8080/api/delete
    public void delete() throws InterruptedException {

        // 삭제시 db logic 약 2초가 걸린다고 가정
        Thread.sleep(1000 * 2);
    }

    @Decode // 값을 변환
    @PutMapping("/put") // http://localhost:8080/api/put
    public Member put(@RequestBody Member member){

        System.out.println("put");
        System.out.println(member);

        return member;
    }
}
