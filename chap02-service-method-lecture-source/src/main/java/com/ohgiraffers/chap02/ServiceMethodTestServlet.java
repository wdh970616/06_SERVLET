package com.ohgiraffers.chap02;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

//    @Override
//    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        // httpRequest의 getMethod() : 어떠한 http method 요청인지 문자열로 반환해준다.
//        String httpMethod = httpRequest.getMethod();
//
//        // a태그의 href 속성은 화면의 url 내용을 변경하는 방식으로, GET 요청에 해당한다.
//        System.out.println("http method : " + httpMethod);
//
//        if ("GET".equals(httpMethod)) {
//            // get 요청을 처리할 메소드로 요청과 응답 정보를 전달한다.
//            doGet(httpRequest, httpResponse);
//        } else if ("POST".equals(httpMethod)) {
//            // post 요청을 처리할 메소드로 요청과 응답 정보를 전달한다.
//            doPost(httpRequest, httpResponse);
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }
}
