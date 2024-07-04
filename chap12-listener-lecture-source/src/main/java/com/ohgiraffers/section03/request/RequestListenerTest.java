package com.ohgiraffers.section03.request;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebServlet;

@WebServlet
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {

    /*
     * 3. request
     *  3-1. ServletRequestListener
     *      - ServletRequest의 생성과 수멸에 대한 이벤트리스너
     *  3-2. ServletRequestAttributeListener
     *      - ServletRequest에 attribute를 추가, 수정, 삭제하는 것에 대한 에\이벤트리스너
     */

    public RequestListenerTest() {
        // context가 로드될 때 생성자를 호출해서 인스턴스가 생성된다.
        System.out.println("request listener 인스턴스 생성");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // request가 생성될 때 호출된다.
        System.out.println("request init!");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // request가 소멸될 때 호출된다.
        System.out.println("request destroyed!");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        // request attribute가 생성될 때 호출된다.
        System.out.println("request attribute added!");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        // request attribute가 삭제될 때 호출된다.
        System.out.println("request attribute removed!");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        // request attribute가 수정될 때 호출된다.
        System.out.println("request attribute replaced!");
    }
}
