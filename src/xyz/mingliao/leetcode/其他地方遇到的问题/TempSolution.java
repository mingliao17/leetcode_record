package xyz.mingliao.leetcode.其他地方遇到的问题;

import com.sun.deploy.util.StringUtils;

/**
 * 某个微信群中发的一道题，字符串给金额数字加逗号，按标准来说可能算是难度很低的
 *
 * 不考虑是否有空格，只考虑标准数字格式，譬如：3254245.56
 *
 * 思路1：转为stringbuffer——找到小数点位置->找到第一个数字的位置->在小数点位置和第一个数字之间倒序每三个一循环加逗号
 * 该思路为当时群主实现，但没有考虑周全边界问题，整数类型的无法实现
 *
 * 思路2：转为array——找到小数点位置->倒序加逗号->在最后加上小数点后的内容
 * 该思路为我实现，没考虑前置中文情况
 */
public class TempSolution {
    public static void solution1(){
        String s = "手机 1234567.59";
        StringBuffer buffer = new StringBuffer().append(s);

        int firstIndex = -1;
        int lastIndex = s.lastIndexOf(".");
        if(-1 == lastIndex){
            lastIndex =   buffer.length();
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])){
                firstIndex = i;
                break;
            }
        }
        for (int i = lastIndex-3; i > firstIndex; i-=3) {
            buffer.insert(i,",");
        }
        System.out.println(buffer);
    }

    public static void solution2(){
        String amount = "3254245.123";
        String result_amount = "";
        //拿到小数点的位置
        int xiaoshudian = amount.lastIndexOf(".");
        if(-1 == xiaoshudian){
            xiaoshudian =   amount.length();
        }
        String[] amountArray = amount.split("");
        //倒序加逗号
        for (int i = xiaoshudian-1; i >= 0; i--) {
            result_amount = amountArray[i] + result_amount;
            if(0 != i && (xiaoshudian-i)%3==0){
                result_amount = "," + result_amount;
            }
        }
        //加上小数点后的内容，其中第一位加的就是小数点
        int xiaoshudain_after = xiaoshudian;
        while(0 < xiaoshudian && xiaoshudain_after < amountArray.length){
            result_amount = result_amount + amountArray[xiaoshudain_after];
            xiaoshudain_after += 1;
        }
        //打印结果集
        System.out.println(result_amount);
    }

    public static void main(String[] args) {
            solution1();
            solution2();
    }

}
