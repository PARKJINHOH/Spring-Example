package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

// @Retention
//해당 애노테이션 정보를 언제까지 유지할 것인가.
//● Source: 소스 코드까지만 유지. 즉, 컴파일 하면 해당 애노테이션 정보는 사라진다는 이야기.
//● Class: 컴파인 한 .class 파일에도 유지. 즉 런타임 시, 클래스를 메모리로 읽어오면 해당 정보는 사라진다.
//● Runtime: 클래스를 메모리에 읽어왔을 때까지 유지! 코드에서 이 정보를 바탕으로 특정 로직을 실행할 수 있다.
@Retention(RetentionPolicy.RUNTIME) // default 애노테이션 정보를 언제까지 유지할 것인가
@Target(ElementType.METHOD) // 어디에 사용할 수 있는지(다양하게 있다.)
@Documented // 해당 애노테이션을 사용한 코드의 문서에 그 애노테이션에 대한 정보를 표기할지 결정한다.
@RequestMapping(method = RequestMethod.GET, value = "/bye")
public @interface GetByeMapping {
}
