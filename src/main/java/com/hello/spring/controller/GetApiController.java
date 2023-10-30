package com.hello.spring.controller;

import com.hello.spring.dto.UserRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:8080/api/get/hello 맵핑
    public String Hello() {
        return "get Hello";
    }

    // 구버전
    // @RequestMapping("/hi") // get, post, put, delete 모든 메서드가 동작한다
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // 속성 get지정, http://localhost:8080/api/get/hi
    public String hi() {
        return "hi";

    }


    /* Path Variable 변화하는 값 받기
       http://localhost:8080/api/get/path-variable/{name} */
    @GetMapping("/path-variable/{name}") // 계속 변하는값 함수 생성
    //public String PathVariable(@PathVariable String Name){ // 변수 이름은 GetMapping에 기재한 이름과 동일해야 함
    public String PathVariable(@PathVariable(name = "name") String pathName) {
        // GetMapping에는 name으로 설정했지만 변수 이름은 다르게 설정해야할 때 name옵션 사용

        System.out.println("PathVariable : " + pathName);

        return pathName; // log에 이름찍기
    }


    /* query Parameter를 받는 3가지 방법
       query parameter: 검색할 때 여러가지 매개인자

    1. Map
       무한정에 어떤 인자값이 들어올지 모를 때 사용

       key+value로 이루어져있고, 다음 key+value가 오기위해선 & 연산자 필요하다
       ?key=value&key2=value2 형식

       http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30 */
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        // Map으로 받을때는 뭐가 들어올지몰라서 뭐든 받을 수 있다.
        // 코딩할때 key를 하나씩 생성해야하는 불편한 점 발생

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
            // append : StringBuilder객체에 문자열을 추가하는 역할
            // 문자열을 수정하거나 연결하는데 발생하는 성능 오버헤드를 피함
        });

        return sb.toString();
    }


    /* 2. 위 단점을 보완하여 RequestParam어노테이션에 모두 명시해주는 방법
          파라미터가 몇개 안될 때 사용하기 */
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+ " "+email+" "+age;
    }

    /* 3. 객체를 만들어서 query Parameter가 바로 맵핑하는 방법
          변수가 계속 늘어남에따라 일일이 requesyParam을 명시하지않고, DTO 형태로 맵핑
          (현업에서 가장 많이 사용, 추천 방법) dto>UserRequest */

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) {

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
