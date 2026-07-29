package com.leetcode.top100liked.lc_0064_minimum_path_sum;

/**
 * LeetCode 64. 最小路径和
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。每次只能向下或者向右移动一步。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        // 1. 初始化第一行（只能从左边往右走）
        for (int j = 1; j < cols; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // 2. 初始化第一列（只能从上面往下走）
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // 3. 填充其余的常规格子
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // 当前格子的数字 + 左边和上边的最小值
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // 右下角的格子就是最终的最小路径和
        return grid[rows - 1][cols - 1];
    }
}

// 核心思路
// 动态规划：原地修改 grid，dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])。
// 先初始化第一行和第一列的边界值（只能单向移动），然后递推填充剩余格子。
//
// 时间复杂度: O(m * n)
// 空间复杂度: O(1) —— 原地修改
