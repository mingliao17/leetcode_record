package xyz.mingliao.else_java_basic.collection;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 制造问题，多个线程修改同一个hashmap的内容，并且查看有什么后果，我这的结果应该有点乱，不应该是走100000次吗，他咋就走了1009次
 */
public class HashMapException {
    public static void main(String[] args) throws InterruptedException {
        HashMap<Integer,String> hashMap = new HashMap();
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        String c = String.valueOf(new Random(1000).nextDouble());
                        hashMap.put(j,c);
                    }
                    countDownLatch.countDown();
                    System.out.println(countDownLatch.getCount());
                }
            }).start();
        }

        countDownLatch.await();

        //打印最终结果
        System.out.println("map个数："+hashMap.size());
        for(int k : hashMap.keySet()){
            System.out.println(k+":"+hashMap.get(k));
        }
    }
}
