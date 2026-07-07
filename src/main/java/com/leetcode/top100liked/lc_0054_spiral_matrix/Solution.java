package com.leetcode.top100liked.lc_0054_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: Solution.java
 * @Author: Warren Wei
 * @Date: 2025/10/21
 * @LeetCode: 0054 螺旋矩阵 (Spiral Matrix)
 * @Link: https://leetcode.com/problems/spiral-matrix/
 * @Description:
 *
 * 给定一个 m x n 的矩阵，按照顺时针螺旋顺序返回矩阵中的所有元素。
 *
 * 解题思路：
 * 1. 使用四个边界变量 top、bottom、left、right 来限定当前未遍历的矩阵区域；
 * 2. 按“从左到右 → 从上到下 → 从右到左 → 从下到上”的顺序遍历；
 * 3. 每遍历完一条边后，将对应的边界向中心收缩；
 * 4. 当边界交叉时，说明所有元素都已遍历完毕。
 *
 * 时间复杂度：O(m * n)，m 为矩阵行数，n 为矩阵列数
 * 空间复杂度：O(1)，不包括存储结果所需的额外空间
 *
 * @Version: 1.0
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
