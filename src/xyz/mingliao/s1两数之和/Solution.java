package xyz.mingliao.s1两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 1是暴力破解，循环次数按理说会非常大
 * 2是使用hashtable不能重复的特性，反向操作，执行次数会更少
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        long firstStart = System.currentTimeMillis();
        System.out.println("twoSum");
        int twoSum[] = new Solution().twoSum(new int[]{2,7,5,4,6,1,13},13);
        for (int s : twoSum){
            System.out.println(s);
        }
        long secondStart = System.currentTimeMillis();
        System.out.println("twoSumHash");
        int twoSumHash[] = new Solution().twoSumHash(new int[]{2,7,5,4,6,1,13},13);
        for (int s : twoSumHash){
            System.out.println(s);
        }
    }
}
