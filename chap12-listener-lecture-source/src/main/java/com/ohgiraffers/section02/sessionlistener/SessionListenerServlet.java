package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 세션만들기
        HttpSession session = request.getSession();
        System.out.println("발급받은 session id : " + session.getId());

        // session 만료하게되면 sessionDestroyed()가 동작한다.
//        session.setMaxInactiveInterval(5);

        // session에 attribute를 추가할 때 attributeAdded()가 동작한다.
        session.setAttribute("userName", "wiseongmin");
        session.setAttribute("age", 28);

        session.setAttribute("user", new UserDTO("wiseongmin", 28));

        // session attribute에 동일한 키로 덮어쓰는 경우(수정) attributeReplaced()가 동작한다.
        session.setAttribute("userName", "wi");

        // session attribute를 제거할 때 attributeRemoved()가 동작한다.
        session.removeAttribute("userName");
    }
}
