package xyz.mingliao.else_java_basic.thread_test;

import java.util.Date;

/**
 * 多线程之间的等待唤醒机制
 */
public class WaitNotifyTest {
    public static void main(String[] args) throws Exception {
        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();
        new Thread(() -> {
            try {
                waitNotifyTest.printFile();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                waitNotifyTest.printFile();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            try {
                System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t睡觉1秒中，目的是让上面的线程先执行，即先执行wait()");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            waitNotifyTest.notifyPrint();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t睡觉三秒，目的是让他再通知一次...");
            waitNotifyTest.notifyPrint();
        }).start();
    }

    private synchronized void printFile() throws InterruptedException {
        System.out.println(new Date() + "\t-" + Thread.currentThread().getName() + "-\t等待打印文件...");
        this.wait();
        System.out.println(new Date() + "\t-" + Thread.currentThread().getName() + "-\t打印结束。。。");
    }

    private synchronized void notifyPrint() {
        this.notify();
        System.out.println(new Date() + "\t" + Thread.currentThread().getName() + "\t通知完成...");


    }
}