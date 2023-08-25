package com.tencent.demo.listener;

import com.sun.tools.attach.VirtualMachine;
import org.aspectj.weaver.loadtime.Agent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.security.CodeSource;

/**
 * just for aspect weaver.
 */
@Configuration
public class SdkStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        try {
            String START_STR = "file:";
            String END_STR = "!/";
            CodeSource codeSource = Agent.class.getProtectionDomain().getCodeSource();
            URL url = codeSource.getLocation();
            String path = url.getPath();
            if (path.startsWith(START_STR) && path.endsWith(END_STR)) {
                path = path.substring(START_STR.length());
                path = path.substring(0, path.length() - END_STR.length());
            }
            File file = new File(path);
            String jvmName = ManagementFactory.getRuntimeMXBean().getName();
            String pid = jvmName.split("@")[0];
            try {
                VirtualMachine virtualMachine = VirtualMachine.attach(pid);
                virtualMachine.loadAgent(file.getAbsolutePath(), "agent-test");
                virtualMachine.detach();
            } catch (NoClassDefFoundError e) {
                e.printStackTrace();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
