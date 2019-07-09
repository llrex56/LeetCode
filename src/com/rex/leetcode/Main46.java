package com.rex.leetcode;

import java.util.*;

public class Main46 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permute(new int[]{1, 3}));
        System.out.println(s.permute(new int[]{1, 2, 3}));
        System.out.println(s.permute(new int[]{1}));
    }

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */
    static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(0, nums, new ArrayList<>(nums.length), new boolean[nums.length], result);
            return result;
        }

        public void dfs(int depth, int[] nums, List<Integer> tmp, boolean[] flag, List<List<Integer>> result) {
            if (depth == nums.length) {
                result.add(new ArrayList<>(tmp));
                return;
            }
            for (int i = 0, len = nums.length; i < len; i++) {
                if (!flag[i]) {
                    tmp.add(nums[i]);
                    flag[i] = true;
                    dfs(depth + 1, nums, tmp, flag, result);
                    flag[i] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}