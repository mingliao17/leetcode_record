package xyz.mingliao.leetcode.s412FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class Solution {

    /**
     * 最简单的解法
     */
    public List<String> fizzBuzz(int n) {
        List<String> stringList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                stringList.add("FizzBuzz");
            }else if (i%3==0){
                stringList.add("Fizz");
            }else if (i%5==0){
                stringList.add("Buzz");
            }else{
                stringList.add(i+"");
            }
        }
        return stringList;
    }

    /**
     * 看了网络上相关的业务侧问题，重构上面的代码
     *
     * 这种耗时和占用内存要比上一种多那么一丢丢，但是对于业务的扩展来说是比较好的
     */
    public List<String> fizzBuzz2(int n){
        List<String> stringList = new ArrayList<>();
        String result = "";
        for(int i=1;i<=n;i++){
            if(i%3==0){
                result+="Fizz";
            }
            if(i%5==0){
                result+="Buzz";
            }
            if("".equals(result)){
                result = i+"";
            }
            stringList.add(result);
            result = "";
        }
        return stringList;
    }

    /**
     * 题解中某个兄台的做法，果真是0ms的速度，超过了100%，直接重写了AbstractList，擦
     *
     * 这个就感觉有点飘忽忽了，目前对list的认知达不到这个程度，这玩意用get方法就能执行循环操作吗，这是咋操作的呢
     */
    public List<String> fizzBuzz3(int n){
        return  new java.util.AbstractList<String>() {
            @Override
            public String get(int i) {
                i++;
                switch ((i % 3 == 0 ? 1 : 0) + (i % 5 == 0 ? 2 : 0)) {
                    case 0:
                        return String.valueOf(i);
                    case 1:
                        return "Fizz";
                    case 2:
                        return "Buzz";
                    case 3:
                        return "FizzBuzz";
                    default:
                        return "";
                }
            }
            @Override
            public int size() {
                return n;
            }
        };
    }


    public static void main(String[] args) {
        int n = 15;
        Solution solution = new Solution();
        List<String> fizzBuzzList = solution.fizzBuzz3(n);
        for (String s : fizzBuzzList){
            System.out.println(s);
        }
    }

}
