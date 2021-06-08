package xyz.mingliao.leetcode.s7整数反转;

/**
 * leetcode巧妙的就是你能有挑战性地去解决问题，还能看到更多牛逼的解决方案
 * 简直就是给我这天天curd的人每天一份小快乐，让自己在感觉没有价值的工作中，感受到一丝编码本身的快乐，让自己变得不那么垃圾，不那么负能量，
 */
public class Solution {
    /**
     * 这是我自己的方法，效率和内存占用都比较差劲
     */
    public int reverse(int x) {
        if(x >= 2147483647 || x <= -2147483648){
            return 0;
        }

        Boolean isNegativeNumber = false;
        if(String.valueOf(x).contains("-")){
            isNegativeNumber = true;
            x = 0-x;
        }

        String[] cArray = String.valueOf(x).split("");

        StringBuffer result = new StringBuffer();


        for(int i=cArray.length-1;i>=0;i--){
            result.append(cArray[i]);
        }

        if(isNegativeNumber){
            result.insert(0,"-");
        }

        double resultDouble = Double.valueOf(result.toString());
        if(resultDouble >= 2147483647 || resultDouble <= -2147483648){
            return 0;
        }
        return Integer.valueOf(result.toString());
    }

    /**
     * 回文数官方题解带来的思路，在他的基础上进行优化
     * @param x
     * @return
     */
    public int reverse2( int x){
        double res = 0;
        int tmp = 0;
        while(x!=0){
            tmp = x% 10;
            res = res*10 + tmp;
            x /= 10;
        }
        if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE){
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse2(4564789));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
