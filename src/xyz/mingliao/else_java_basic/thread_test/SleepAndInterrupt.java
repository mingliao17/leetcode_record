package xyz.mingliao.else_java_basic.thread_test;

import java.util.Date;

/**
 * 睡眠和唤醒
 */
public class SleepAndInterrupt {


    public static void main(String[] args) throws Exception {
        Thread thread0 = new Thread(() -> {
            try {
                System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t太困了，让我睡10秒，中间有事叫我，zZZ。。。");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t被叫醒了，又要继续干活了");
            }
        });
        thread0.start();

        // 这里睡眠只是为了保证先让上面的那个线程先执行
        Thread.sleep(3000);

//        new Thread(() -> {
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t醒醒，醒醒，别睡了，起来干活了！！！");
            // 无需获取锁就可以调用interrupt
            thread0.interrupt();
//        }).start();
    }
}
