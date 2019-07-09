package com.rex.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main77 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4,2));
        System.out.println(s.combine(5,2));
        System.out.println(s.combine(5,3));
    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     */
    static class Solution {

        static int n;
        static int k;
        static List<List<Integer>> result;

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            this.result = new ArrayList<>();
            dfs(1, new LinkedList<>());
            return result;
        }

        public void dfs(int first, List<Integer> list) {
            if (list.size() == k) {
                result.add(new LinkedList<>(list));
                return;
            }
            for (int i = first; i <= n; i++) {
                list.add(i);
                dfs(i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}