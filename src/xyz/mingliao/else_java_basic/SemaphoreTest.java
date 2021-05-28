package xyz.mingliao.else_java_basic;

import java.util.concurrent.Semaphore;

/**
 * 信号量单纯方法测试
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        System.out.println("init print:"+semaphore.availablePermits());
        //释放自定义数量个许可，将其返回给信号量，不填写默认为1
        semaphore.release(2);
        System.out.println("release after print:"+semaphore.availablePermits());
        //从此信号量获取自定义数量个许可，在提供一个许可前一直将线程阻塞，否则线程被中断，不填写默认为1
        semaphore.acquire();
        //返回此信号量中当前可用的许可数
        System.out.println("acquire after print:"+semaphore.availablePermits());
        System.out.println("是否有线程正等待获取:"+semaphore.hasQueuedThreads());

    }
}
