package xyz.mingliao.else_java_basic.thread_test;

import java.util.Date;

/**
 * join方法测试
 */
public class JoinTest {
    public static void main(String[] args) {
        new Thread(new ParentRunnable()).start();
    }
}

class ParentRunnable implements Runnable {
    @Override
    public void run() {
        // 线程处于new状态
        Thread childThread = new Thread(new ChildRunable());
        // 线程处于runnable就绪状态
        childThread.start();
        try {
            // 当调用join时，parent会等待child执行完毕后再继续运行
            // 将某个线程加入到当前线程
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "父线程 running");
        }
    }
}

class ChildRunable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "子线程 running");
        }
    }
}