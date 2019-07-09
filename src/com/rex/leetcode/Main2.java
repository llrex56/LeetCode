package com.rex.leetcode;

public class Main2 {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);

        ListNode list2 = new ListNode(5);

        ListNode result = new Solution().addTwoNumbers(list1, list2);
        System.out.println(result);
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead, p = l1, q = l2;

            int carry = 0;
            while(p != null || q != null) {
                int x = p != null ? p.val : 0;
                int y = q != null ? q.val : 0;
                int sum = carry + x + y;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;

                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
                carry = sum / 10;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }
}