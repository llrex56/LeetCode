package com.rex.leetcode;

import java.util.HashMap;
import java.util.Map;

// Main136
public class MajorityElement {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3,2,3}));
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(solution.majorityElement(new int[]{1, 2, 1, 2, 1}));
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
    static class Solution {
        public int majorityElement(int[] nums) {
            int max = Integer.MIN_VALUE;
            int len = nums.length;
            Map<Integer, Integer> dict = new HashMap<>(len);

            for (int i = 0; i < len; i++) {
                Integer n = dict.get(nums[i]);

                if (n == null) {
                    n = 0;
                }
                dict.put(nums[i], n += 1);

                if (max < n) {
                    max = n;

                    if (len % 2 == 0 && max == len / 2) {
                        return nums[i];
                    }
                    if (len % 2 != 0 && max > len / 2) {
                        return nums[i];
                    }
                }
            }
            return 0;
        }
    }
}
