package com.hello.spring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class MapToJson { // Map > JSON
    public static void main(String[] args){

        var objectMapper = new ObjectMapper();

        Map<String, Object> data = new HashMap<>(); // Map 객체 생성
        data.put("name", "john");
        data.put("age", 30);
        data.put("city", "seoul");

        try{
            String json = objectMapper.writeValueAsString(data); // Map을 JSON 문자열로 변환

            System.out.println(json); // JSON 문자열 출력
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
