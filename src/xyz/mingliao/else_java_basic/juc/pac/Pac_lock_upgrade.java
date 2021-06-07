package xyz.mingliao.else_java_basic.juc.pac;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock实现生产消费者，condition精准唤醒
 *
 *
 */
public class Pac_lock_upgrade {
}

class Data3{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sdfasdfasdf123");
        System.out.println(stringBuffer);
        stringBuffer.reverse();
        System.out.println(stringBuffer);

        ArrayList a = new ArrayList();
        HashSet hs = new HashSet();
        HashMap hm = new HashMap();

        Integer f1 = 100,f2=100,f3=150,f4=150;
        System.out.println(f1==f2);
        System.out.println(f3==f4);
        LinkedList linkedList = new LinkedList();

        ReadWriteLock readWriteLock;

    }


}
