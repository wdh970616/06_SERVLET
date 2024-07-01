package com.ohgiraffers.section02.formdata;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 인코딩 타입 확인
        System.out.println("request : " + request.getCharacterEncoding());

        // POST 방식으로 요청 내용을 확인하는 것도 GET 요청으로 파라미터를 처리하는 방식이랑 동일함,
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        // 모든 데이터의 key를 이용해서 전송된 값을 일괄 처리할 수 있다.
        System.out.println("전달받은 모든 데이터 조회");

        // Value값이 문자열 배열일수도 있기 때문에 String[]으로 설정
        Map<String, String[]> requestMap = request.getParameterMap();
        Set<String> keySet = requestMap.keySet(); // 모든 키 받기
        Iterator<String> keyIter = keySet.iterator();

        // 참고용으로만 확인하기
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            String[] value = requestMap.get(key);

            System.out.println("key : " + key);
            for (int i = 0; i < value.length; i++) {
                System.out.println("value[" + i + "] : " + value[i]);
            }
        }

        // 파라미터로 전달된 키 목록만 확인
        System.out.println("파라미터로 전달된 키 목록 확인");
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
    }
}
