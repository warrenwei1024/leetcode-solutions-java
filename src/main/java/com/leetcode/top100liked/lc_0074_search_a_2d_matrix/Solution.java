package com.leetcode.top100liked.lc_0074_search_a_2d_matrix;

/**
 * LeetCode 74. 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
 * 该矩阵具有如下特性：
 * - 每行中的整数从左到右按升序排列。
 * - 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-08
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 空矩阵处理
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;      // 行数
        int n = matrix[0].length;   // 列数

        // 将二维矩阵视为一维有序数组，进行二分查找
        int left = 0;
        int right = m * n - 1;      // 一维数组的右边界

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 关键：将一维索引映射回二维坐标
            // row = mid / n（行号），col = mid % n（列号）
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                // 目标在右半部分
                left = mid + 1;
            } else {
                // 目标在左半部分
                right = mid - 1;
            }
        }

        // 未找到目标值
        return false;
    }
}

// 核心思路
// 将 m×n 矩阵视为长度为 m×n 的一维有序数组。
// 该矩阵满足：每行升序，且每行首元素大于上一行末元素，
// 因此展开为一维后天然有序，可直接二分查找。
// 一维索引 k 对应二维坐标：row = k / n，col = k % n。
//
// 时间复杂度: O(log(m·n))
// 空间复杂度: O(1)
