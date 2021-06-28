package xyz.mingliao.else_java_basic.thread_pool_test;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class UserThreadHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("我被拒绝了:"+executor.getActiveCount()+executor.getCompletedTaskCount()
            +executor.getCorePoolSize()+executor.getQueue());
    }
}
