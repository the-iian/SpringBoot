package com.hello.spring.controller;

import com.hello.spring.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

//    Map의 형태
//    @PostMapping("/post")
//    public void post(@RequestBody Map<String, Object> requestData){
//
//        requestData.forEach((key, value) -> {
//            System.out.println("key : " + key);
//            System.out.println("value : " + value);
//        });
//    }

    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData){
        // Post로 맵핑하는 데이터는 RequestBody 어노테이션 명시, RequestDto 객체 생성 필요

        System.out.println(requestData);

    }
}
