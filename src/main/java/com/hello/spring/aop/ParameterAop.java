package com.hello.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect // AOP로 동작하기 위함
@Component // 스프링에 관리 의탁
public class ParameterAop { // AOP - 각 메서드마다 log를 찍는 부분을 한곳으로 모을 수 있다


    // 실행순서 2
    @Pointcut("execution(* com.hello.spring.controller..*.*(..))") // 조인 포인트를 결정
    private void cut(){

    }


    // 실행순서 1
    @Before("cut()") // 위 pointcut이 실행되는 지점에 before때 해당 메서드를 실행
    public void before(JoinPoint joinPoint){

        // 메소드 이름 출력
        // 메소드가 많이 생기던 말던 pointcut을 통해 외부에서 메소드명을 바라볼 수 있다
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs(); // 메서드에 들어가고있는 매개변수들의 배열

        for(Object obj : args){
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }

    }


    // 실행순서 3
    @AfterReturning(value = "cut()", returning = "returnObj") // pointcut에서 반환값을 실행
    public void afterReturn(JoinPoint joinPoint, Object returnObj){

        System.out.println("return obj");
        System.out.println(returnObj);

    }

}
