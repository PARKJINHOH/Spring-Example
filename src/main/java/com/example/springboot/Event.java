package com.example.springboot;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class Event {

    interface ValidateLImit {}
    interface ValidateName {}


    private Integer id;

//    @NotBlank(groups = ValidateName.class) // 해당 애노테이션이 들어갈 그룹 지정(실습을 위해 주석)
    @NotBlank
    private String name;

//    @Min(value = 0, groups = ValidateLImit.class)
    @Min(0)
    private Integer limit;
}
