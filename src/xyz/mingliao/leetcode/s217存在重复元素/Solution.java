package xyz.mingliao.leetcode.s217存在重复元素;

import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 * 我觉得解法还是，用hashset保存内容，最后和数组比较数量，如果相等就位false不等就位true
 */
public class Solution {

    /**
     * 耍小聪明，使用之前的伎俩，用hashset去重，然后比对原有长度
     *
     * 结果是对的，但速度和内存利用不太友好
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums){
            hashSet.add(i);
        }
        if(hashSet.size() == nums.length){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 明天再写优化的版本吧
     */
    public boolean containsDuplicate2(int[] nums){

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2};
        System.out.println(solution.containsDuplicate(nums));
    }
}
