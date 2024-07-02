package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/otherservlet")
public class OtherServletRedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("get 요청 정상 수락");
        System.out.println(response);
        response.sendRedirect("redirect");
    }
}
