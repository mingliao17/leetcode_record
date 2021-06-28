package xyz.mingliao.else_java_basic.thread_pool_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Task implements Runnable{

    private final static AtomicLong a = new AtomicLong(1L);

    @Override
    public void run() {
        //睡三秒，假装执行“换衣服”任务
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我队服换好了，我是召唤师num_"+a.getAndIncrement());
    }
}