package com.leetcode.top100liked.lc_0048_rotate_image;

/**
 * LeetCode 48. 旋转图像
 * <p>
 * 给定一个 n x n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public void rotate(int[][] matrix) {
        // 边界处理
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        int n = matrix.length;

        // 1. 沿主对角线（左上到右下）翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. 水平翻转每一行
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}

// 核心思路
// 顺时针旋转 90 度 = 先沿主对角线转置，再水平翻转每一行。
// 等价于 matrix[i][j] → matrix[j][n-1-i]，分两步完成可避免额外矩阵空间。
//
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)
