package com.ohgiraffers.section01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        System.out.println("name = " + name);

        String fullName = "위" + name;
        request.setAttribute("fullName", fullName);

        Member member = new Member("홍길동", 20);
        request.setAttribute("member", member);

        HttpSession session = request.getSession();
        session.setAttribute("fullName", "홍홍길동");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/testForward.jsp");
        dispatcher.forward(request, response);
    }
}
