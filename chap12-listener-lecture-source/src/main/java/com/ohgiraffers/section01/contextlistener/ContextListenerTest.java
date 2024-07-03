package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /*
     * 리스너
     * - 리스너는 특정 이벤트 행위가 동작할때 컨테이너에 의해 호출되는 메소드를 인터페이스에 정의해둠.
     * 이를 상속받아 구현한 메소드가 특정 이벤트 발생에 대해 필요한 로직을 작성한다.
     * 1. context(=> 톰캣 컨테이너 자체에 리스너를 연결)
     *  1-1. ServletContextListener : 웹어플리케이션의 시작, 종료에 대한 이벤트리스너
     *  1-2. ServletContextAttributeListener : context에 attribute를 추가, 제거, 수정에 대한 이벤트리스너
     */

    public ContextListenerTest() {
        // context가 실행될 때 변화를 감지하는 리스너 인스턴스가 생성된다.
        System.out.println("context listener 인스턴스 생성");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // context가 최초 생성될 때 생성자 호출 이후 동작하는 메소드
        System.out.println("context init!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // context가 소멸할 때 동작하는 메소드
        System.out.println("context destroy!");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        // context에 attribute가 추가될 때 동작하는 메소드
        System.out.println("context attribute added!");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        // context에 attribute가 제거될 때 동작하는 메소드
        System.out.println("context attribute removed!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        // context에 attribute가 변경될 때 동작하는 메소드
        System.out.println("context attribute replaced!");
    }
}
