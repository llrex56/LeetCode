package com.rex.leetcode;

public class Palindrome {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(".,"));
        System.out.println(solution.isPalindrome("0P"));
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     */
    static class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();

            for (int i = 0, len = chars.length, j = len - 1; i < j; i++, j--) {
                while (i <= j && !this.isValidChar(chars[i])) {
                    i++;
                }
                while (i <= j && !this.isValidChar(chars[j])) {
                    j--;
                }
                if (i < j && !this.equalsIgnoreCase(chars[i], chars[j])) {
                    return false;
                }
            }
            return true;
        }

        private boolean equalsIgnoreCase(char x, char y) {
            return x == y || String.valueOf(x).equalsIgnoreCase(String.valueOf(y));
        }

        private boolean isValidChar(char ch) {
            return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
        }
    }
}
