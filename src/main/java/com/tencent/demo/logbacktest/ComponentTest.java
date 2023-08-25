package com.tencent.demo.logbacktest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ComponentTest {

    private static Logger logger = LoggerFactory.getLogger(ComponentTest.class);
    static String data = LogInit.init();

    @Pointcut("execution(* com.huya..*Controller*.*(..))")
    public void excudeNomralReturnLog() {
    }

    private static String getData() {
//        StartLogTest.LogRunner logRunner = new StartLogTest().new LogRunner();
//        new Thread(logRunner).start();

        StartLogTest.start=true;
        String test= "test main";
        logger.info("test main logback:{}", test);

//        for(int i=0; i<1000; i++) {
//            logger.info("test main logback:{}", "test"+i);
//        }
        return "suc";
    }
}
