package com.rex.leetcode;

import java.util.*;

public class Main22 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.generateParenthesis(2);
        for (String str : result) {
            System.out.println(str);
        }
    }

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * 例如，给出 n = 3，生成结果为：
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     */
    static class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            this.dfs(list,"", 0, 0, n);
            return list;
        }

        public void dfs(List<String> list, String current, int open, int close, int max) {
            if (current.length() == max * 2) {
                list.add(current);
                return;
            }
            if (open < max) {
                dfs(list,current + "(", open + 1, close, max);
            }
            if (close < open) {
                dfs(list,current + ")", open, close + 1, max);
            }
        }
    }
}