package com.rex.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main78 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets(new int[]{2, 3}));
        System.out.println(s.subsets(new int[]{1, 2, 3}));
        System.out.println(s.subsets(new int[]{2, 3, 5}));
    }

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * 说明：解集不能包含重复的子集。
     * 示例:
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */
    static class Solution {

        static List<List<Integer>> result;

        public List<List<Integer>> subsets(int[] nums) {
            this.result = new ArrayList<>();
            dfs(0, nums, new LinkedList<>());
            return result;
        }

        public void dfs(int index, int[] nums, List<Integer> list) {
            result.add(new ArrayList<>(list));

            for (int i = index, len = nums.length; i < len; i++) {
                list.add(nums[i]);
                dfs(i + 1, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }
}