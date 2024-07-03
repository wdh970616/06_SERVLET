package com.ohgiraffers.section01.session;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("(session) firstname : " + firstName);
        System.out.println("(session) lastname : " + lastName);

//        response.sendRedirect("redirect");

        // 세션 만들기
        HttpSession session = request.getSession();

        // HttpSession의 기본 유지시간은 30분으로 저장되어있다.
        session.setMaxInactiveInterval(60 * 10); // 10분으로 설정
        System.out.println("변경후 session 유지시간 : " + session.getMaxInactiveInterval());

        System.out.println("session id : " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        response.sendRedirect("redirect");
    }
}
