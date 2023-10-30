package com.hello.spring.controller;

import com.hello.spring.dto.PostRequestDto;
import com.hello.spring.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    // 변수명은 메소드에 선언한 이름과 일치해야한다. 만약, 일치시킬 수 없으면 @PathVariable에 property-name을 속성을 지정해서 개별로 지정 가능하다
    public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable Long userId){
    // public PutRequestDto put(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId) Long id){

        System.out.println(requestDto);

        return requestDto;

    }
}
