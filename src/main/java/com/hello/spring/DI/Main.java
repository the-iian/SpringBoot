package com.hello.spring.DI;

public class Main {

    public static void main(String[] args){

        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        //  요구사항 : Base 64로 encoding
        //  Encoder encoder = new Encoder();
        //  String result = encoder.encode(url);
        //  System.out.println(result);

        // 새 요구사항 : url encoding - 추상화x
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);

        System.out.println(result);
    }
}
