package com.example.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
@Component
public class ExampleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("==== ExampleFilter init ====");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("==== ExampleFilter doFilter Start ====");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("==== ExampleFilter doFilter End ====");
    }

    @Override
    public void destroy() {
        log.info("==== ExampleFilter destory ====");
    }
}
