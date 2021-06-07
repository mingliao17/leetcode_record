package xyz.mingliao.concurrent_art.c1并发编程的挑战;

/**
 * 书上第一份代码
 *
 * 串行和并行比速度
 *
 * 主要比赛内容：执行两个小方法，一个正向+，一个反向-
 * 串行：正向+执行完之后再执行反向-，执行完后结束
 * 并行：启动一个新的线程执行正向+，然后原有线程执行反向-，有一个thread.join在等待正向+的线程执行完后整个方法才能结束
 */
public class ConcurrencyTest {

    /**
     * 尝试修改这个既定大小
     * 我自己的笔记本测试记录：
     * 量越少串行越厉害，五百万打平，六百万并行提前一毫秒
     */
    private static final long count = 600_0000L;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(long i =0;i<count;i++){
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for(long i=0;i<count;i++){
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis()-start;
        System.out.println("concurrency:"+time+"ms,b="+b);
    }

    public static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for(long i=0;i<count;i++){
            a += 5;
        }
        int b =0;
        for(long i=0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis()-start;
        System.out.println("serial:"+time+"ms,b="+b);
    }
}
