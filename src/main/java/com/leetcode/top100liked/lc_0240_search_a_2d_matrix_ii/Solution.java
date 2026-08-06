package com.leetcode.top100liked.lc_0240_search_a_2d_matrix_ii;

/**
 * LeetCode 240. 搜索二维矩阵 II
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
 * 该矩阵具有以下特性：每行的元素从左到右升序排列，每列的元素从上到下升序排列。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 空矩阵处理
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;      // 行数
        int n = matrix[0].length;   // 列数

        // 从左下角开始搜索
        int row = m - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                // 当前值小于目标，目标不可能在本列，向右移动
                col++;
            } else {
                // 当前值大于目标，目标不可能在本行，向上移动
                row--;
            }
        }

        // 遍历完所有可能的行列仍找不到
        return false;
    }
}

// 核心思路
// 从右上角（或左下角）开始搜索，利用行列有序性逐步缩小范围。
// 以左下角为例：当前值 < target 则右移（排除本列），> target 则上移（排除本行）。
// 每次操作排除一整行或一整列，形成 Z 字形搜索路径。
//
// 时间复杂度: O(m + n)
// 空间复杂度: O(1)
