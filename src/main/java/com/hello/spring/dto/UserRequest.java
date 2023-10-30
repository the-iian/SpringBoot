package com.hello.spring.dto;

public class UserRequest {

    /* 변수가 계속 늘어남에따라 일일이 requesyParam을 명시하지않고,
       DTO 형태로 맵핑하는 방법 (현업에서 가장 많이 사용) */

    private String name;
    private String email;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // toString 자동완성 활용
    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
