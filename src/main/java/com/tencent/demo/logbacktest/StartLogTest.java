package com.tencent.demo.logbacktest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StartLogTest {

    private static final Logger logger = LoggerFactory.getLogger(StartLogTest.class);

    public static boolean start = false;

    private final static StartLogTest Instance = new StartLogTest();

    private ScheduledThreadPoolExecutor taskExecutor = new ScheduledThreadPoolExecutor(1);

    public static StartLogTest getInstance() {
        return Instance;
    }

    public void start() {
        Runnable serverStartingHandler = new Thread(new StartLogTest().new NodeStartingHandleThread(), "ServerStarting-");
        taskExecutor.scheduleAtFixedRate(serverStartingHandler, 0, 5, TimeUnit.SECONDS);
    }

    public class NodeStartingHandleThread implements Runnable {
        int i=0;
        @Override
        public void run() {
            String app = "app";
            String svr = "svr";
            logger.info("{}.{} starting, ScheduledNodeStartingMngr NodeStartingHandleThread run, updateKeepAliveTime:{}....",
                    app, svr,i);
            i++;
        }
    }


}
