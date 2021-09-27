package xyz.mingliao.else_java_basic.juc.tools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int randomS = new Random(10).nextInt();
                    System.out.println("线程"+Thread.currentThread().getName()+"开始睡眠");
                    try {
                        TimeUnit.SECONDS.sleep(3L);
                        System.out.println("线程"+Thread.currentThread().getName()+"睡了"+3+"秒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cdl.countDown();
                }
            }).start();
        }

        cdl.await();
        System.out.println("到此结束了宝");
    }
}
