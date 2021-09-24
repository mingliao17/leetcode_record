package xyz.mingliao.else_java_basic.collection;

/**
 * 因为hashmap中的hash取值用的是Object中的hashcode方法，我就看看如果是12345这种数字，hash后他的内容分布情况
 *
 * 第一个方法返回内容都是int类型的，捎带着部分排序的感觉
 * 第二个方法就凌乱了，好多负数的存在，整体也没有排序的感觉
 */
public class HashCodeTest {
    public static void main(String[] args) {
        for (Double i = Double.valueOf(1); i < 1000; i=i++) {
            System.out.println(i.hashCode());
        }

        for (double i = 0; i < 1000; i=i+0.1) {
            System.out.println(String.valueOf(i).hashCode());
        }
    }
}
