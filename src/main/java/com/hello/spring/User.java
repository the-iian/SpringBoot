package com.hello.spring;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User { // Object Mapper 동작 방식

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;


    // default 생성자 추가
    public User(){
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // 생성자 오버로딩 (Alt+Insert)
    public User(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    // 유념사항
    // public User getDefaultUser(){ 와 같이 메소드를 만들때 get을 붙일때가 있는데,
    // 해당 클래스가 object mapper에서 활용될때는 get을 메소드명에서 지워야한다
    public User defaultUser(){
        return new User("default", 0, "010-1111-2222");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

