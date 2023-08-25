package com.tencent.demo.logbacktest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogInit {

    static Logger log = LoggerFactory.getLogger(LogInit.class);

    public static String init() {
        String test= "test main";
        log.info("test main logback:{}", test);
        return "suc";

    }
}
