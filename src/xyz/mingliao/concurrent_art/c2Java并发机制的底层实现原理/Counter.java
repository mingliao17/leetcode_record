package xyz.mingliao.concurrent_art.c2Java并发机制的底层实现原理;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用循环cas实现原子操作
 */
public class Counter {
    private AtomicInteger atomicI = new AtomicInteger();
    private int i =0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int j=0;j<100;j++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }
        //执行所有线程
        for(Thread t : ts){
            t.start();
        }
        //等待所有线程执行完毕
        for(Thread t : ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("非线程安全计数器得数："+cas.i);
        System.out.println("线程安全计数器得数："+cas.atomicI.get());
        System.out.println("执行时间"+(System.currentTimeMillis()-start)+"ms");
    }

    /**
     * 线程安全计数器
     */
    private void safeCount(){
        for(;;){//这种无限循环方式不占用寄存器，没有判断跳转，网络上说比while(1)好，但方法体内部不还是得有一个判断来做停止操作吗
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i,++i);
            if(suc){
                break;
            }
        }
    }

    /**
     * 非线程安全计数器
     */
    private void count(){
        i++;
    }
}
