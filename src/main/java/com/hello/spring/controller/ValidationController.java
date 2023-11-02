package com.hello.spring.controller;

import com.hello.spring.dto.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class ValidationController {

    @PostMapping("/company") // http://localhost:8080/api/company
    public ResponseEntity company(@Valid @RequestBody Company company, BindingResult bindingResult){ // Validation이 붙은 객체는 내부를 검증함

        if (bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> { // 어떤 에러인지 메시지 받기
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field :" + field.getField());
                System.out.println(message);

                sb.append("field : " + field.getField());
                sb.append("message :"+ message); // 어떤 양식으로 넣어야하는지 예시 넣기

            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        // logic
        return ResponseEntity.ok(company);
    }
}
