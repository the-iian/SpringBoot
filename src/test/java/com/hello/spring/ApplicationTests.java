package com.hello.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    /* 스프링에서 내부적으로 req가 들어오면 object로 바꿔준다

      controller 외에 따로 객체를 json으로 바꿔야 할 때는
      objectMapper를 생성하고 writeValueAsString 또는 readValue를 통해
      json > object 또는 object > json으로 바꿔준다 */

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("---------");

        // Test JSON > Object
        // Object > Text JSON

        // controller req json(text) > object
        // response object > json(text)

        var objectMapper = new ObjectMapper();

        // object > text 로 바뀔때
        // object mapper는 get method를 참조한다
        var user = new User("steve", 10, "010-1111-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text > object
        // object mapper는 default 생성자를 필요로한다
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);

    }
}
