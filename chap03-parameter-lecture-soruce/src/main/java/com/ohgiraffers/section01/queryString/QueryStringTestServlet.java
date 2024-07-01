package com.ohgiraffers.section01.queryString;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/querystring"/* url은 소문자로 하는것이 암묵적인 규칙이다. */)
public class QueryStringTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         * HttpServlet 클래스의 service method는 요청 방식에 따라
         * GET 요청에 대해서는 doGet() 메소드를 호출하고 request, responce를 전달한다.
         */

        // service로부터 전달받은 HttpServletRequest는 요청시 전달한 값을 getParameter() 메소드로 추출할 수 있다.
        String name = request.getParameter("name");
        System.out.println("이름 : " + name);

        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("나이 : " + age);

        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        System.out.println("생일 : " + birthday);

        String gender = request.getParameter("gender");
        System.out.println("성별 : " + gender);

        String national = request.getParameter("national");
        System.out.println("국적 : " + national);

        System.out.println("취미 : ");
        String[] hobbies = request.getParameterValues("hobbies");

        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
    }
}
