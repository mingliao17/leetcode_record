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

    public static void main(String[] args) {
        new Solution().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 8);
    }
}
