package com.ohgiraffers.section02.delete;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("===== delete 요청 있음 =====");

        HttpSession session = request.getSession();
        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        /*
         * 세션 데이터를 지우는 방법
         * 1. 설정한 만료시간이 지나면 세션이 완료된다.
         * 2. removeAttribute()로 ssession의 Attribute를 지운다.
         * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.
         */

//        System.out.println("===== removeAttribute()로 firstName 삭제 =====");
//        session.removeAttribute("firstName");
//        sessionNames = session.getAttributeNames();
//        while (sessionNames.hasMoreElements()) {
//            System.out.println(sessionNames.nextElement());
//        }

        System.out.println("===== invalidate 이후 =====");
        session.invalidate();
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }
    }
}
