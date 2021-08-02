package com.example.springboot;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

//    ?: 한 글자 (“/author/???” => “/author/123”) , (“/author?” => “/author3”)
//    *: 여러 글자 (“/author/*” => “/author/keesun”)
//    **: 여러 패스 (“/author/** => “/author/keesun/book”)

    @GetMapping({"/hello", "/hi"})
    @ResponseBody // @ResponseBody를 붙이면 hello를 return하며, 안붙이면 hello.html을 찾는다.
    public String hello() {
        return "hello";
    }

    /* Header 정보 요청*/
    @GetMapping(value = "/json",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String headerRequest() {
        return "hello";
    }

    /* Header 정보 요청*/
    @GetMapping(value = "/header"
                , headers = HttpHeaders.FROM)
    @ResponseBody
    public String header() {
        return "hello";
    }

    /* 커스텀 애노테이션 */
    @GetByeMapping
    @ResponseBody
    public String bye() {
        return "bye";
    }




}
