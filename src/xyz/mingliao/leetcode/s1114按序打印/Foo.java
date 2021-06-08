package xyz.mingliao.leetcode.s1114按序打印;

import java.util.concurrent.Semaphore;

/**
 * 按序打印（使用信号量亦或原子类实现）
 *
 * 我搞懂这个semaphore下面的两个方法了，但还是不知道这个按序打印的算法是如何调用的
 */
class Foo {

    //信号量
    private Semaphore two = new Semaphore(0);
    private Semaphore three = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


}