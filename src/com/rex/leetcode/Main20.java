package com.rex.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main20 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("{[]}"));
        System.out.println(s.isValid(""));
        System.out.println(s.isValid("]"));
        System.out.println(s.isValid("["));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     */
    static class Solution {

        Map<Character, Character> dict = new HashMap<>();

        {
            dict.put('(', ')');
            dict.put('[', ']');
            dict.put('{', '}');
        }

        public boolean isValid(String s) {
            if ("".equals(s)) {
                return true;
            }
            char[] chars = s.toCharArray();

            Stack<Character> stack = new Stack<>();

            for (char ch : chars) {
                if (dict.containsKey(ch)) {
                    stack.push(dict.get(ch));
                } else if (stack.isEmpty() || (!stack.isEmpty() && !stack.pop().equals(ch))) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}