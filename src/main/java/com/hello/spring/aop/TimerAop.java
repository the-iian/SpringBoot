package com.hello.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect // AOP로 동작하기 위함
@Component // 스프링에 관리 위탁
public class TimerAop { // 특정 메소드의 실행시간을 찍는 AOP

    @Pointcut("execution(* com.hello.spring.controller..*.*(..))") // 조인 포인트를 결정
    private void cut(){}

    @Pointcut("@annotation(com.hello.spring.annotation.Timer)") // 어노테이션 제약 걸기
    private void enableTimer(){}

    @Around("cut() && enableTimer()") // AOP의 before, after메서드는 시간 공유가 안되서 Around를 사용함
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed();
        // proceed 호출시 실제 메서드가 실행되고, 만약 리턴타입이 있다면 Object가 리턴된다

        stopWatch.stop();

        System.out.println("total time : " + stopWatch.getTotalTimeSeconds()); // 초 단위 출력

    }

}
