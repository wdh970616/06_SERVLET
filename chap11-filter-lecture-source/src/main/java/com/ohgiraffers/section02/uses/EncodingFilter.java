package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {

    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hRequest = (HttpServletRequest) servletRequest;
        if ("POST".equals(hRequest.getMethod())) {
            System.out.println("기존 인코딩 타입 : " + hRequest.getCharacterEncoding());
            hRequest.setCharacterEncoding("UTF-8");
            System.out.println("변경된 인코딩 타입 : " + hRequest.getCharacterEncoding());
        }
        filterChain.doFilter(hRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
