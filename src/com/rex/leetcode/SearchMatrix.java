package com.rex.leetcode;

// Main240
public class SearchMatrix {

    public static void main(String[] args) {
        /*int[][] array = new int[][] {
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };*/
        int[][] array = new int[][] {
        };
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(array, 5));
        System.out.println(solution.searchMatrix(array, 20));
        System.out.println(solution.searchMatrix(array, 1));
        System.out.println(solution.searchMatrix(array, 30));
        System.out.println(solution.searchMatrix(array, 18));
        System.out.println(solution.searchMatrix(array, 15));
    }

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * 示例:
     * 现有矩阵 matrix 如下：
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false
     */
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }
            int i = 0, j = matrix[0].length - 1;

            while(i < matrix.length && j >= 0) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }
    }
}
