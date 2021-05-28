package xyz.mingliao.s7整数反转;

/**
 * 这是我自己的方法，效率和内存占用都比较差劲
 */
public class Solution {
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

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-153));
    }
}
