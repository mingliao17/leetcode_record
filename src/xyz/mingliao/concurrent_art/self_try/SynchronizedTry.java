package xyz.mingliao.concurrent_art.self_try;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * 锁顺序，锁的是谁，静态方法知否被锁
 */
public class SynchronizedTry {

    public static void main(String[] args)  {
        BusinessContent b = new BusinessContent();
        new Thread(()->{
            b.change_data();
        }).start();

        new Thread(()->{
            b.say_goodbye();
        }).start();
    }
}

class BusinessContent{

    public synchronized void change_data(){
        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("change");
    }

    public synchronized void say_goodbye(){
        System.out.println("goodbye");
    }

}
