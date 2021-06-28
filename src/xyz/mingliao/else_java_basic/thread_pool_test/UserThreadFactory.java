package xyz.mingliao.else_java_basic.thread_pool_test;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger();

    public UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's-" + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null,task,name,0);
        System.out.println(thread.getName());
        return thread;
    }
}

