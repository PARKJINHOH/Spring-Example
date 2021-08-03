package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void hiTest() throws Exception {
        mockMvc.perform(get("/hi"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void headerRequestTest() throws Exception {
        mockMvc.perform(get("/json")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                        .accept(MediaType.APPLICATION_JSON)) // 현재 PLAIN_VALUE로 return한다고 알려주기 때문에 406ERORR, accecpt를 지정하지 않으면 모두 받는다.
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void headerTest() throws Exception {
        mockMvc.perform(get("/header")
                        .header(HttpHeaders.FROM, "localhost"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void bytTest() throws Exception {
        mockMvc.perform(get("/bye"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("bye"));
    }

}