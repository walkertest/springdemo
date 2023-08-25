package com.tencent.demo.listener;

import com.tencent.demo.logbacktest.StartLogTest;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class TestStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("TestStartingLIstener on ApplicationStartingEvent.....");

        //annother thread to start logback format messagelog
        StartLogTest.getInstance().start();
    }

}
