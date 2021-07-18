package xyz.mingliao.leetcode.其他地方遇到的问题;


import java.util.Arrays;

/**
 * 目前还是错误的二分查找，这是还没修复而已
 *
 * 参考与算法第四版
 */
public class BinarySearch {

    public static int rank (int key,int[]a){
        //数组必须有序
        int lo = 0;
        int hi = a.length-1;
        while(lo <= hi){
            //被查找的键要么不存在，要么必然存在于a[lo...hi]之中
            int mid = lo + (hi- lo) /2;
            if(key<a[mid]){
                hi = mid + 1;
            } else if (key < a[mid]) {
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whilelist = new int[]{1,2,5,6,9,11,22,33,55,66,88,98,99,110,121,132,165,189,233};
        Arrays.sort(whilelist);
        System.out.println(rank(9,whilelist));
    }

}
