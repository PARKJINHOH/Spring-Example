package com.example.springboot;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {


    /* 핸들러 메소드 홈 서브밋*/
    @GetMapping("/events/form")
    public String eventsFrom(Model model){
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "/events/form";
    }

    // 요청 매개변수
//    @PostMapping("/events")
//    @ResponseBody
//    public Event requestParamsEvents(@RequestParam String name,
//                                     @RequestParam Integer limit) {
//        Event event = new Event();
//        event.setName(name);
//        event.setLimit(limit);
//        return event;
//    }

    // 요청 매개변수 ModelAttribute
    @PostMapping("/events")
    public String requestParamsEvents(@Validated @ModelAttribute Event event,
                                      BindingResult bindingResult,
                                      Model model) {
        // @Validated(Event.ValidateName.class) Limit만 사용하겠다.라는 뜻. 다른 그룹은 사용하지 않겠다.


        // bindingResult Integer타입을 받아야 하는데 String이 들어왔다면 binding Error가 나는 부분을 null로 변경
        if (bindingResult.hasErrors()) {
            System.out.println("======================");
//            bindingResult.getAllErrors().forEach(c->{
//                System.out.println(c.toString());
//            });

            return "/events/form";
        }

        // redirect, 새로고침을 할 때 경고창이 나온다. 동일한 데이터인데 다시 요청을 보내겠냐고, 그래서 해당 경고를 방지하고자 수정
        // 데이터 베이스에서 save를 해야한다. (지금은 db 미사용이여서 아래 메소드에서 하드코딩)
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model) {

        // DB Select
        Event event = new Event();
        event.setName("spring");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);
        return "/events/list";
    }




    /* 핸들러 메소드 학습 */

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event events(@PathVariable Integer id) {
        Event event = new Event();
        event.setId(id);
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
