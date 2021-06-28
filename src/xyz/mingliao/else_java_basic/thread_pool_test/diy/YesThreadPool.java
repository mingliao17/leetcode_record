package xyz.mingliao.else_java_basic.thread_pool_test.diy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class YesThreadPool {

    BlockingQueue<Runnable> taskQueue;  //存放任务的阻塞队列
    List<YesThread> threads; //线程列表

    YesThreadPool(BlockingQueue<Runnable> taskQueue, int threadSize) {
        this.taskQueue = taskQueue;
        threads = new ArrayList<>(threadSize);
        // 初始化线程，并定义名称
        IntStream.rangeClosed(1, threadSize).forEach((i)-> {
            YesThread thread = new YesThread("yes-task-thread-" + i);
            thread.start();
            threads.add(thread);
        });
    }
    //提交任务只是往任务队列里面塞任务
    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    class YesThread extends Thread { //自定义一个线程
        public YesThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            while (true) { //死循环
                Runnable task = null;
                try {
                    task = taskQueue.take(); //不断从任务队列获取任务
                } catch (InterruptedException e) {
                    System.out.println("抛出异常..."+e);
                }
                task.run(); //执行
            }
        }
    }
}