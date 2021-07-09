package xyz.mingliao.leetcode.s350两个数组的交集2;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Solution {

    /**
     * 没思路，参考题解：排序加双指针
     */
    public int[] intersect(int[] nums1, int[] nums2) {


        return null;
    }

    /**
     * 题解2
     * 使用哈希表
     */
    public int[] intersect2(int[] num1, int[] nums2){

        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        int[] nums3 = s.intersect(nums1,nums2);
        for (int n : nums3){
            System.out.println(n);
        }
    }
}
