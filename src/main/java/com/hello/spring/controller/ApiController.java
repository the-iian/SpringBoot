package com.hello.spring.controller;

import com.hello.spring.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // REST API 처리하는 컨트롤러
@RequestMapping("/api") // URI를 지정해주는 어노테이션 (집주소)
public class ApiController {

    @GetMapping("/hello") // http://localhost:8080/api/hello 맵핑 (상세주소)
    public String hello(){
        return "hello spring boot!";
    }


    // TEXT 에코형태로 계정받기
    @GetMapping("/text") // http://localhost:8080/api/text?account=user100
    public String text(@RequestParam String account){

        return account;
    }


    // json - 제일 많이 사용하는 방법
    @PostMapping("/json") // http://localhost:8080/api/json
    public User json(@RequestBody User user){
        // user 객체를 RequestBody로 받아서 user를 return

        return user;

        // 동작 원리
        // request > object mapper > object > method > object > object mapper > json > response
    }


    /* ResponseEntity - 응답에 대한 커스터마이징이 필요할때 사용
       Http상태 코드를 직접 제어할 수 있는 클래스
       ResponseEntity를 통해 명확하게 답을 내려서 받는걸 가장 권장하는 방법

       ResponseEntity 구조 - HttpStatus, HttpHeaders, HttpBody */
    @PutMapping("/put2") // http://localhost:8080/api/put
    public ResponseEntity<User> put(@RequestBody User user){

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
        // object mapper를 통해 json으로 바뀌여 응답이 내려감
        // put으로 요청했을때, response가 생성되면 response가 201을 내려준다 (CREATED =201)

    }
}
