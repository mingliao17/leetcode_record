package xyz.mingliao.else_java_basic.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 尝试触发这个异常
 *
 * 在使用iterator迭代内容时，修改内部数据
 */
public class ConcurrentModificationException {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer i  = iterator.next();
            if(i == 2){
                list.remove(i);
            }
        }
    }
}
