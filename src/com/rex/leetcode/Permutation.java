package com.rex.leetcode;

public class Permutation {

    static int n = 3;
    static int[] arr = new int[n];
    static boolean[] flag= new boolean[n + 1];

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                arr[depth] = i;
                flag[i] = true;
                dfs(depth + 1);
                flag[i] = false;
            }
        }
    }
}
