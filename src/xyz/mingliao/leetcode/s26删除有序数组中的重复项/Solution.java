package xyz.mingliao.leetcode.s26删除有序数组中的重复项;

import java.util.HashSet;

/**
 * 我觉得这个问题提出的也有问题，要的还是一个删除重复数据后数组的数量
 */
public class Solution {

    /**
     * 按照官方推荐使用双指针来解决这个问题，能通过他给的提示写出这样的代码
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
        int leftPointer = 0;//左针
        for(int rightPointer=1;rightPointer<nums.length;rightPointer++){
            if(nums[leftPointer] != nums[rightPointer]){
                nums[++leftPointer] = nums[rightPointer];
            }
        }
        return ++leftPointer;//左指针代指所处位置，从零开始，但个数不是从零开始，故执行++操作
    }

    /**
     * 尝试的使用hashSet能得到对应结果，但leetcode却说不对,可能是违背了他不能开辟新的内存空间的意图
     * @param nums
     * @return
     */
    public int removeDuplicates_hashset(int[] nums) {
        HashSet hNums = new HashSet();
        for (int i=0;i<nums.length;i++){
            hNums.add(nums[i]);
        }
        return hNums.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1,1,2}));
    }
}
