package com.leetcode.top100liked.lc_0073_set_matrix_zeroes;

/**
 * LeetCode 73. 矩阵置零
 * <p>
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。
 * 请使用原地算法。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;

        // 1. 标记第一行和第一列原本是否有 0
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // 检查第一行
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // 检查第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // 2. 使用第一行和第一列作为标记数组
        // 遍历除第一行第一列之外的元素
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 标记对应的行首和列首
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 3. 根据标记将内部元素置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果该行首或该列首为 0，则当前元素置 0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. 最后处理第一行和第一列
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

// 核心思路
// 使用第一行和第一列作为标记数组，避免 O(mn) 额外空间。
// 先用两个布尔值记录第一行/第一列本身是否有 0，然后遍历内部元素做标记，
// 根据标记置零内部元素，最后处理第一行和第一列。
//
// 时间复杂度: O(m * n)
// 空间复杂度: O(1)