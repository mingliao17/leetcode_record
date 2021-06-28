package xyz.mingliao.else_java_basic.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类尝试
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
        atomicInteger.incrementAndGet();
        atomicInteger.compareAndSet(1,3);
        System.out.println(atomicInteger.get());

    }
}
