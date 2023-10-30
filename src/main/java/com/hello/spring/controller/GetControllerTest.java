package com.hello.spring.controller;

import com.hello.spring.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/iian/api")
public class GetControllerTest {

    @GetMapping("/first") // http://localhost:8080/iian/api/first 맵핑
    public String First(){
        return "done!";
    }

    @GetMapping("/path-variable/{name}")
    public String PathVariable(@PathVariable String name){

        System.out.println("PathVariable : " + name);

        return name;
    }

    // 1. Map : 어떤 인자값이 들어올지 모를 때 사용
    @GetMapping("query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + "=" + entry.getValue() + "\n");

        });

        return sb.toString();
    }

    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
