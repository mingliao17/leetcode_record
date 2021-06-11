package xyz.mingliao.else_java_basic.thread_pool_test;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        BlockingQueue blockingDeque = new LinkedBlockingQueue(10);

        UserThreadFactory userThreadFactory = new UserThreadFactory("第一机房");

        UserThreadHandler userThreadHandler = new UserThreadHandler();

        ThreadPoolExecutor tpe1 = new ThreadPoolExecutor(
                1,2,20,TimeUnit.SECONDS,blockingDeque,userThreadFactory,userThreadHandler);

        Task task = new Task();

        for (int i = 0; i < 200; i++) {
            tpe1.execute(task);
        }
    }
}
