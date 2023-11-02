package com.hello.spring.dto;

import com.hello.spring.annotation.YearMonth;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Company {

    @NotBlank // 띄어쓰기+공백 허용안함
    private String ename;
    private String job;

    @Email // Validation:이메일 양식에 맞지않으면 에러 (validation 사용시 정규식하지않아도 됨)
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰번호의 양식과 맞지않습니다. 01x-xxxx-xxxx")
    private String phoneNumber;


    //@Size(min = 6, max = 6)
    @YearMonth // 생성한 어노테이션 - yyyyMM
    private String reqYearMonth;

    @Max(value = 90) // 최대값
    private int age;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /* 임의의 6자리 숫자 이외에 년도와 월이 입력되도록
    재사용이 불가능해서 매번 같은 코드중복이 나온다 → YearMonthValidator 생성 (재사용가능한 코드)
    @AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다.")
    public boolean isreqYearMonthValidation(){ // AsserTrue메서드는 꼭! is 키워드로 시작해야한다

        // parsing
        try{
            LocalDate localdate = LocalDate.parse(getReqYearMonth()+"01", DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (Exception e) {
            return false;
        }
        return true;
    } */

    @Override
    public String toString() {
        return "Company{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                ", age=" + age +
                '}';
    }
}

