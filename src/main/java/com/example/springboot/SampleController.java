package com.example.springboot;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event events(@PathVariable Integer id) {
        Event event = new Event();
        event.setId(id);
        return event;
    }

    // 요청 매개변수
    @PostMapping("/events")
    @ResponseBody
    public Event requestParamsEvents(@RequestParam String name) {
        Event event = new Event();
        event.setName(name);
        return event;
    }

    @GetMapping("/matrixEvents/{id}")
    @ResponseBody
    public Event matrixVariableEvents(@PathVariable Integer id, @MatrixVariable String name) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }


}
