package xyz.mingliao.else_java_basic.thread_pool_test;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //初始化队列
        BlockingQueue blockingDeque = new LinkedBlockingQueue(3);
        //创建工厂对象
        UserThreadFactory userThreadFactory = new UserThreadFactory("FPX战队更衣室");
        //创建拒绝策略
        UserThreadHandler userThreadHandler = new UserThreadHandler();
        //构建线程池
        ThreadPoolExecutor tpe1 = new ThreadPoolExecutor(
                1,2,20,TimeUnit.SECONDS,blockingDeque,userThreadFactory,userThreadHandler);
        //申明任务对象
        Task task = new Task();
        //线程池发力时刻
        for (int i = 1; i <= 6; i++) {
            tpe1.execute(task);
        }
        //用完了记得关闭线程池，要不然他会一直占着资源
        tpe1.shutdown();

        tpe1.shutdown();
    }
}
