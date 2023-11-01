package com.hello.spring.aop;

import com.hello.spring.dto.Member;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect // AOP 사용
@Component // 스프링에 관리 위탁
public class DecodeAop {

    @Pointcut("execution(* com.hello.spring.controller..*.*(..))") // 조인 포인트를 결정
    private void cut(){}

    @Pointcut("@annotation(com.hello.spring.annotation.Decode)") // 어노테이션 제약 걸기
    private void enableDecode(){}


    // 암호화된 코드 복호화 된 상태로 들여오기
    // (전:decode 후:인코딩해서 내보내기)
    // 값을 찾기 - method에 넘어가는 argument 찾음
    @Before("cut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs(); // before method가 실행될 때 args 파라미터중에

        for (Object arg : args) { // loop돌면서 특정 변수나, 매개인자에서 원하는 값 찾기
            if (arg instanceof Member) { // 내가 원하는 member.class가 있으면 (instanceof:객체타입 확인 및 검증하는 연산자)
                Member member = Member.class.cast(arg); // argument를 돌다가 내가 찾는 member.class가 매칭되면 member class로 형변환
                String base64Email = member.getEmail(); // 기존에 인코딩되어있던 Email 추출
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8"); // email을 다시 디코딩
                member.setEmail(email); // 디코딩된 이메일을 다시 멤버에 세팅
            }
        } // 위 코드를 통해 controller에서 member class를 decode할 일을 없애준다
    }

    @AfterReturning(value = "cut() && enableDecode()", returning="returnObj") // @AfterReturning:메서드가 반환된 후 실행된 메서드 지정, 메서드가 반환하는 객체를 returnObj에 저장
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        if (returnObj instanceof Member) { // returnObj 객체가 Member class에 인스턴스인지 확인
            Member member = Member.class.cast(returnObj); // returnObj 객체를 Member class로 형변환하여 변수 member에 저장 = 이제 returnObj를 Member객체로 사용 가능
            String email1 = member.getEmail(); // 기존에 인코딩되어있던 Email 정보 추출
            String base64Email = Base64.getEncoder().encodeToString(email1.getBytes()); // 가져온 이메일정보를 인코딩하여 base64Email에 저장 (이메일 정보 보호, 변환 등)
            member.setEmail(base64Email); // Member객체의 이메일 필드를 새로운 Base64 인코딩된 문자열 'base64Email'로 설정, 반환된 Member 객체 이메일정보가 수정된다

            }
        } // obj에서 member를 찾아 email을 다시 인코딩해서 다시 set해주고 return
    }
