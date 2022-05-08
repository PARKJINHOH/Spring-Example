package com.example.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExampleController {

    @GetMapping("/hello")
    public String hello() {
        log.info("=== Controller : hello ===");
        return "hello";
    }

    @GetMapping("/hi")
    public String hi() {
        log.info("=== Controller : hi ===");
        return "hi";
    }

}
