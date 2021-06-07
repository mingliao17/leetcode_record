package xyz.mingliao.else_java_basic.juc.pac;

/**
 * 线程中生产者消费者
 * 线程交替进行 ab操作同一个变量 num=0
 *
 * synchronized加锁，业务代码实现加减操作
 */
public class Pac_synchronized {

    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for(int i=0;i<10;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

class Data{
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        //if判断语句修改为while，防止虚假唤醒问题
        while(number!=0){
            //等待
            this.wait();
        }
        number++;
        //通知其他线程我+1，完毕
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while(number==0){
            //等待
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程我-1，完毕
        this.notifyAll();
    }
}