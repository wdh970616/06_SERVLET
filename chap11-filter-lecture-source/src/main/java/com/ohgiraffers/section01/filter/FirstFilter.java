package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/*
 * 특정 주소에만 필터를 걸고 싶다면
 * @WebFilter("/first/filter")
 */

@WebFilter("/first/*") // /first 로 시작하는 모든 url 요청에 필터를 걸어줌
public class FirstFilter implements Filter {

    // 기본 생성자
    public FirstFilter () {
        // 필터는 톰캣을 start 하는 시점부터 인스턴스를 미리 생성한다.
        System.out.println("FirstFilter 인스턴스 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 인스턴스가 최초 생성될때 호출되는 메소드
        System.out.println("Filter init 호출");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Servlet으로 request가 전달되기 전에 요청을 가로채는 역할을 하는 메소드
        System.out.println("Filter doFilter 호출");

        // 필터에서 처리할 코드가 작성되는 공간

        // 처리 이후 다음 필터 혹은 서블릿의 doGet/doPost 를 호출한다.
        filterChain.doFilter(servletRequest, servletResponse);

        // 서블릿에서 처리 이후에 다시 수행할 내용이 있으면 작성
        System.out.println("Servlet 요청 수행 완료");
    }

    @Override
    public void destroy() {
        // 필터 인스턴스가 소멸될때 호출되는 메소드(= 톰캣 종료시)
        System.out.println("Filter destroy 호출");
    }
}
