package com.example.demo.annotation.filter.config;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "testFilter1",urlPatterns ={"/aaa/*","/bbb/*","/ccc/*"})
public class FilterConfig implements Filter {

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("beforetestFilter1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("aftertestFilter1");
    }

    @Override
    public void destroy() {

    }
}
