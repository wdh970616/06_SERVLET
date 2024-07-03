package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

    // HttpServletRequestWrapper는 기본생성자가 없기 때문에 request를 전달해주는 생성자가 필요하다.
    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String key) {

        String value = "";
        if ("password".equals(key)) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            // 암호화
            value = passwordEncoder.encode(super.getParameter(key));

            System.out.println("value = " + value);
        } else {
            value = super.getParameter(key);
        }
        return value;
    }
}
