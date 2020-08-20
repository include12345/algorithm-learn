package com.lihebin.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lihebin on 2020/8/20.
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 */
public class TwoNumSum {


    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     * @throws Exception
     */
    private static int[] twoSum1(int[] nums, int target) throws Exception {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new Exception("没有答案");
    }

    /**
     * 两遍哈希
     *
     * @param nums
     * @param target
     * @return
     * @throws Exception
     */
    private static int[] twoSum2(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[] {i, map.get(temp)};
            }
        }
        throw new Exception("没有答案");
    }


    /**
     * 一遍哈希
     *
     * @param nums
     * @param target
     * @return
     * @throws Exception
     */
    private static int[] twoSum3(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {i, map.get(temp)};
            }
            map.put(nums[i], i);
        }
        throw new Exception("没有答案");
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        int target = 8;
        try {
            System.out.println(Arrays.toString(twoSum2(nums, target)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
