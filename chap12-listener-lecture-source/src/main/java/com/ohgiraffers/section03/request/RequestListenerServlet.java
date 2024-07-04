package com.ohgiraffers.section03.request;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/request")
public class RequestListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request에 attribute를 추가할 때 attributeAdded()가 동작한다.
        request.setAttribute("userName", "wiseongmin");
        request.setAttribute("age", 28);
        request.setAttribute("gender", 'M');

        // request에 attribute를 동일한 키로 덮어쓸 때(수정) attributeReplaced()가 동작한다.
        request.setAttribute("userName", "wi");

        // request에 attribute를 제거할 때 attributeRemoved()가 동작한다.
        request.removeAttribute("userName");

    }
}
