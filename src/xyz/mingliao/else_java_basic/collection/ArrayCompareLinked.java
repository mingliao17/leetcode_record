package xyz.mingliao.else_java_basic.collection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 为啥搞起插入来，arraylist反而要比linkedlist快很多
 */
public class ArrayCompareLinked {

    public void array(){
        Long start = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList<>();
        for (int i = 0; i < 1000_0000; i++) {
           arrayList.add("mingliao is not know list's speed!");
        }
        System.out.println("array times:"+(System.currentTimeMillis() - start)+"ms");
    }

    public void linked(){
        Long start = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 1000_0000; i++) {
            linkedList.add("mingliao's content");
        }
        System.out.println("lined times:"+(System.currentTimeMillis() - start)+"ms");

    }

    public static void main(String[] args) {
        ArrayCompareLinked arrayCompareLinked = new ArrayCompareLinked();
        arrayCompareLinked.array();
        arrayCompareLinked.linked();
    }
}
