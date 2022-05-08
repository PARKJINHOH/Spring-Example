package com.example.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
//@Order(1) -- filter의 순서를 정할 수 있다. 하나만 실행되는게 아닌 다른 필터까지 실행되지만 순서를 정할 떄 사용
public class ExampleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("==== ExampleFilter init ====");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("==== ExampleFilter doFilter Start ====");
        log.info("uri : {}", ((HttpServletRequest)servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("==== ExampleFilter doFilter End ====");
    }

    @Override
    public void destroy() {
        log.info("==== ExampleFilter destory ====");
    }
}
