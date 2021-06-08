package xyz.mingliao.s189旋转数组;

public class Solution {
    /**
     * 使用临时数组,最low的我的解法
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] new_nums = new int[length];

        //这是最后加的，之前没考虑k比nums.length长的情况，也是看了官方题解的临时数组方法才考虑到的，这个和官方的差不了多少
        k = k%length;

        //先把k的这后半段放到新数组的前面
        for (int i = 0; i < k; i++) {
            new_nums[i] = nums[length - k + i];
        }
        //再把k之前的前半段放到新数组的后面
        for (int i = k; i < length; i++) {
            new_nums[i] = nums[i - k];
        }
        //把临时数组的内容给到nums
        System.arraycopy(new_nums, 0, nums, 0, length);
        //打印一下
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**
     * 官方的临时数组解法
     *
     * 人家这个思路还是牛逼，但我不知道我差在了哪里
     *
     * 我知道我差再哪里了，没有考虑k的范围
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
        //打印一下
        for (int i : nums) {
            System.out.println(i);
        }
    }


    /**
     * 官方题解方法2没有看懂，环状替换，看是看懂了，但是思路没懂
     */
    public void rotate3(int[] nums, int k) {

    }

    /**
     * 官方题解方法3，数组反转
     *
     * 这个版本速度快，但内存消耗打，但我觉得循环是差不多的，甚至这个循环还多一些，为啥这个方法就快呢
     */
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        //反转整个数组
        reverse(nums,0,nums.length-1);
        //反转0-k区间
        reverse(nums,0,k-1);
        //反转k-nums.length区间
        reverse(nums,k,nums.length-1);
        //打印一下
        for (int i : nums) {
            System.out.println(i);
        }
    }

    /**
     * 基于官方题解3的子方法
     * @param nums
     * @param start
     * @param end
     */
    public void reverse(int[] nums,int start,int end){
        while( start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        new Solution().rotate4(new int[]{1, 2, 3, 4, 5, 6, 7}, 8);
    }
}
