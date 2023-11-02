package com.hello.spring.validator;

import com.hello.spring.annotation.YearMonth;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


// @YearMonth 어노테이션을 활용하는 클래스
public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.pattern = constraintAnnotation.pattern(); // 초기화했을 때 값 지정
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // 정상적인 패턴이 들어오는지 검사할 값 확인
        // yyyyMM
        try{
            LocalDate localdate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern));
            // +"01"을 붙이는건 dd가 없으면 에러발생해서 임의로 디폴트 1을 붙여서 검색하는 것

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
