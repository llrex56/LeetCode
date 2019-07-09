package com.rex.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main14 {

    public static void main(String[] args) {
        String[] strs = new String[]{
                "flower",
                "flow",
                "flight"
        };
        System.out.println("flow".indexOf("flower"));
        System.out.println("flow".indexOf("flowe"));
        System.out.println("flow".indexOf("flow"));

        String result = new Solution().longestCommonPrefix(strs);
        System.out.println(result);
    }

    /**
     */
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String prefix = strs[0];

            for (int i = 1; i < strs.length; i++)

                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);

                        if (prefix.isEmpty()) {
                            return "";
                    }
                }
              return prefix;
        }
    }
}