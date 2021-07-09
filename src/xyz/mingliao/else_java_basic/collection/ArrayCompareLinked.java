package xyz.mingliao.else_java_basic.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 为啥搞起插入来，arraylist反而要比linkedlist快很多
 *
 * 有待考究
 */
public class ArrayCompareLinked {

    public static void array(){
        Long start = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        for (int i = 0; i < 100_0000; i++) {
           arrayList.add(100+i,i);
        }
        System.out.println("array times:"+(System.currentTimeMillis() - start)+"ms，size="+arrayList.size());
    }
    public static void linked(){
        Long start = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        for (int i = 0; i < 100_0000; i++) {
            linkedList.add(100+i,i);
        }
        System.out.println("linked times:"+(System.currentTimeMillis() - start)+"ms，size="+linkedList.size());
    }

    public static void main(String[] args) {
//        ArrayCompareLinked arrayCompareLinked = new ArrayCompareLinked();
        ArrayCompareLinked.array();
        ArrayCompareLinked.linked();
    }
}
