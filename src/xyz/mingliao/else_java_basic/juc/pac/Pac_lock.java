package xyz.mingliao.else_java_basic.juc.pac;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 尝试使用lock实现消费者生产者
 *
 * 4个线程轮流交替执行
 */
public class Pac_lock {


    public static void main(String[] args) {
        Data2 data2 = new Data2();
        //走4个线程，一个加接替一个减
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    data2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    data2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    data2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    data2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}

class Data2 {
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * 增加
     */
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //业务代码

            //if判断语句修改为while，防止虚假唤醒问题
            while (number != 0) {
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            //通知其他线程我+1，完毕
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 减少
     */
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            //业务代码

            while (number == 0) {
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            //通知其他线程我-1，完毕
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}