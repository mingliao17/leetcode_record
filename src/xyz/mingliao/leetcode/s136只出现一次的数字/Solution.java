package xyz.mingliao.leetcode.s136只出现一次的数字;

import java.util.Arrays;

public class Solution {
    //一如既往暴力破解
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1){
                return nums[i];
            }
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    nums[j] = nums[nums.length-1];
                    nums[i] = nums[nums.length-2];
                    nums = Arrays.copyOf(nums, nums.length-2);
                    i--;
                    if(1 == nums.length){
                        return nums[0];
                    }
                    break;
                }
            }
        }
        return 0;
    }

    //先排序再遍历，参考题解中网友的回答
    public int singleNumber2(int[] nums){
        Arrays.sort(nums);
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }else {
                i++;
            }
        }
        return nums[nums.length-1];
    }


    //最优解，异或运算
    //时间最快，但是内存消耗只超过了60%的人,可能就是因为声明了一个int对象吧
    public int singleNumber3(int[] nums){
        int result = nums[0];
        if(nums.length>1){
            for (int i = 1; i <nums.length ; i++) {
                result = result ^ nums[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new  Solution();
        int[] nums = new int[]{2,2,1};
        int result = solution.singleNumber3(nums);
        System.out.println(result);
    }
}
