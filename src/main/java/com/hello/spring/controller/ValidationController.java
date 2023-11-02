package com.hello.spring.controller;

import com.hello.spring.dto.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @PostMapping("/company") // http://localhost:8080/api/company
    public ResponseEntity company(@Valid @RequestBody Company company){ // Validation이 붙은 객체는 내부를 검증함
        System.out.println(company);

        if (company.getAge() >= 90){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(company);
        }

        return ResponseEntity.ok(company);

    }
}
