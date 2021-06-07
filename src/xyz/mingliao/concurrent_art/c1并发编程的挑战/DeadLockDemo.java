package xyz.mingliao.concurrent_art.c1并发编程的挑战;

import java.sql.SQLOutput;

/**
 * 死锁示例
 * 死的不能再死了
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    //这个睡眠很重要,不睡就不会死
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }


}
