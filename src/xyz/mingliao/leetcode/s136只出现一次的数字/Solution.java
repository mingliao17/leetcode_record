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


    public static void main(String[] args) {
        Solution solution = new  Solution();
        int[] nums = new int[]{1,0,1};
        int result = solution.singleNumber(nums);
        System.out.println(result);
    }
}
