package xyz.mingliao.data_structure;

/**
 *  看漫画算法有感，来找一个二分查找试试感觉
 *  方法概述：给定一个数组和int类型变量，找到int变量在数组中的下标位置，如果没有找到则返回-1
 *
 *  三种方式：寻找一个数、寻找左侧边界、寻找右侧边界
 */
public class BinarySearchSolution {

    //寻找一个数（最基础的二分查找）
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) { // 注意
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

                        //今天先看个基础的，难的后面再写
    //寻找左侧边界的二分查找
    //寻找右侧边界的二分查找


    public static void main(String[] args) {
        BinarySearchSolution b = new BinarySearchSolution();
        int[] nums = new int[]{3,2,1,5,68,7};
        int result = b.binarySearch(nums,68);
        System.out.println(result);
    }

}
