package com.ohgiraffers.section01.othersite;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/othersite")
public class OtherSiteRedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("get 요청 후 naver 사이트로 redirect");
        response.sendRedirect("http://www.naver.com");
    }
}
