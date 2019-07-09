package com.rex.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main784 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCasePermutation("a1b2"));
        System.out.println(s.letterCasePermutation("3z4"));
        System.out.println(s.letterCasePermutation("12345"));
        System.out.println(s.letterCasePermutation("A1h56u3"));
    }

    /**
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     * 示例:
     * 输入: S = "a1b2"
     * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
     * 输入: S = "3z4"
     * 输出: ["3z4", "3Z4"]
     * 输入: S = "12345"
     * 输出: ["12345"]
     * 注意：
     * S 的长度不超过12。
     * S 仅由数字和字母组成
     */
    static class Solution {
        public List<String> letterCasePermutation(String S) {
            List<String> result = new ArrayList<>();
            dfs(0, "", S.toCharArray(), result);
            return result;
        }

        public void dfs(int depth, String str, char[] ch, List<String> result) {
            if (depth == ch.length) {
                result.add(str);
                return;
            }
            dfs(depth + 1, str + ch[depth], ch, result);

            if (ch[depth] >= 'a' && ch[depth] <= 'z') {
                dfs(depth + 1, str + String.valueOf(ch[depth]).toUpperCase(), ch, result);
            }
            if (ch[depth] >= 'A' && ch[depth] <= 'Z') {
                dfs(depth + 1, str + String.valueOf(ch[depth]).toLowerCase(), ch, result);
            }
        }
    }
}