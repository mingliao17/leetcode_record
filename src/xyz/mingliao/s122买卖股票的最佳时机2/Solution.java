package xyz.mingliao.s122买卖股票的最佳时机2;

/**
 *  我觉得题目不太精准，应该是买卖股票的最大收益，因为要的终究是一个能获得的最大金额,像是这个方法名称
 */
public class Solution {
    public int maxProfit(int[] nums) {
        int max =0 ;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] < nums[i+1]){
                max = max + nums[i+1]-nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,4,5}));
    }
}
