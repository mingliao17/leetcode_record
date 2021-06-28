package xyz.mingliao.else_java_basic.juc.list;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestArrayListError {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
