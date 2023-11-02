package com.hello.spring.dto;

import javax.validation.constraints.*;

public class Company {

    @NotBlank // 띄어쓰기+공백 허용안함
    private String ename;
    private String job;

    @Email // Validation:이메일 양식에 맞지않으면 에러 (validation 사용시 정규식하지않아도 됨)
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰번호의 양식과 맞지않습니다. 01x-xxxx-xxxx") // 핸드폰번호 정규식
    private String phoneNumber;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Company{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}

