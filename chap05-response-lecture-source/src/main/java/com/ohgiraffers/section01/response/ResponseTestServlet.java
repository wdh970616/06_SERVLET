package com.ohgiraffers.section01.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {

    /*
     * 서블릿이 하는 역할 3가지
     * 1. 요청 받기 - HTTP method GET/POST 요청에 따라 parameter로 전달받은 데이터를 꺼낼 수 있다.
     * 2. 비즈니스 로직 처리 - DB 접속과 CRUD에 대한 로직 처리 -> 서비스를 호출하는 쪽으로 해결한다. (MVC)
     * 3. 응답하기 - 문자열로 동적인 웹(HTML 태그)페이지를 만들고 스트림을 이용해 내보낸다.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 사용자 브자우저에 응답학 위해서는 HttpServletReponse의 getWriter() method로 PrintWriter 인스턴스를 반환받는다.
        // PrintWriter는 BufferedWriter와 형제격인 클래스이지만 더 많은 생성자를 제공하고 이로인한 범용성으로 인해 더 많이 사용한다.
        PrintWriter out = response.getWriter();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕 서블렛 response</h1>\n")
                .append("</body>\n")
                .append("</html>");

        // 브라우자로 내보낼 데이터의 타입을 응답 헤더에 설정해줘야한다.
        // default type이 null이기때문에 수정 필요함.
        System.out.println("default response type : " + response.getContentType());
        response.setContentType("text/html");

        // 추가사항 : 인코딩 방식변경
        response.setCharacterEncoding("UTF-8");

        // 인코딩과 MIME타입을 한번에 설정할 수 있다.
        response.setContentType("text/html; charset=UTF-8");
        response.setContentType("text/plain; charset=UTF-8"); // plain으로 설정하면 작성한 그대로 보여줌

        out.println(responseBuilder.toString());
        out.flush();
        out.close();
    }
}
