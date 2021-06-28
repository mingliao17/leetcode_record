package xyz.mingliao.else_java_basic.thread_test;

public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("mingliao");

        Thread thread = new Thread(()->{
            System.out.println("new thread param:"+threadLocal.get());
        });
        thread.start();

        System.out.println("main thread param:"+threadLocal.get());
    }
}
