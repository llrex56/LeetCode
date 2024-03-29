package com.rex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15, 7};
        int target = 9;
        int[] result = new Solution().twoSum(nums, target);

        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : result) {
            list.add(i);
        }
        System.out.println(list);
    }

    /**
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0, len = nums.length; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
        }
    }
}