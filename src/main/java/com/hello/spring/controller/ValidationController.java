package com.hello.spring.controller;

import com.hello.spring.dto.Company;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ValidationController {

    @PostMapping("/company") // http://localhost:8080/api/company
    public Object company(@RequestBody Company company){

        System.out.println(company);
        return company;

    }
}
