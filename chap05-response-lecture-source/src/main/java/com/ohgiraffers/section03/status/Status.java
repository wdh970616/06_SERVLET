package com.ohgiraffers.section03.status;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/status")
public class Status extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 200, 400, 401, 404, 500
        response.sendError(200 , "요청이 성공적으로 처리되었습니다.");
        response.sendError(400 , "잘못된 요청입니다.");
        response.sendError(401 , "누구세요?");
        response.sendError(404, "없는 페이지입니다. 경로를 확인해주세요.");
        response.sendError(500 , "서버가 처리방법을 알 수 없습니다.");
    }
}
