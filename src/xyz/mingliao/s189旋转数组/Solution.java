package xyz.mingliao.s189旋转数组;

public class Solution {
    /**
     * 使用临时数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] new_nums = new int[nums.length];
        int k_after=0;
        for(int i=nums.length-k;i<nums.length;i++){
            new_nums[k_after] = nums[i];
            k_after++;
        }
        int k_before=nums.length-k-1;
        for(int i=k;i>=0;i--){
            new_nums[k_before] = nums[i];
            k_before++;
        }
        nums = new_nums;

        for (int i : nums){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
       new Solution().rotate(new int[]{1,2,3,4,5,6,7},6);
    }
}
