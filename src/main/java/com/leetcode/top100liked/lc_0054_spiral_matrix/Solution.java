package com.leetcode.top100liked.lc_0054_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 54. 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix，请按照顺时针螺旋顺序，
 * 返回矩阵中的所有元素。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // 处理空矩阵的情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;      // 矩阵行数
        int n = matrix[0].length;   // 矩阵列数

        // 定义四个边界
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        // 当边界未交叉时继续遍历
        while (top <= bottom && left <= right) {

            // 1. 从左到右遍历上边
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++;

            // 2. 从上到下遍历右边
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;

            // 3. 从右到左遍历下边（需要确保下边仍有效）
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // 4. 从下到上遍历左边（需要确保左边仍有效）
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }

        return result;
    }
}

// 核心思路
// 维护上下左右四个边界，按"右→下→左→上"的顺序逐层遍历。
// 每遍历完一条边收缩对应边界，并检查边界是否交叉防止重复遍历。
//
// 时间复杂度: O(m * n)
// 空间复杂度: O(1) —— 不计结果列表
