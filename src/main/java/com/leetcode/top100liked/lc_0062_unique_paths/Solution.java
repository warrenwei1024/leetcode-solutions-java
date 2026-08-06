package com.leetcode.top100liked.lc_0062_unique_paths;

/**
 * LeetCode 62. 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角。机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角。问总共有多少条不同的路径？
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示到达 (i, j) 的路径数
        // 空间优化：只用一维数组，dp[j] 表示到达当前行第 j 列的路径数
        int[] dp = new int[n];

        // 第一行所有位置都只有 1 种路径（一直向右）
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // 逐行计算
        for (int i = 1; i < m; i++) {
            dp[0] = 1;   // 每行第一列也只有 1 种路径
            for (int j = 1; j < n; j++) {
                // dp[j] = 从上方来（dp[j] 旧值）+ 从左方来（dp[j-1] 新值）
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}

// 核心思路
// 动态规划：dp[i][j] = dp[i-1][j] + dp[i][j-1]。
// 第一行和第一列都只有 1 种路径。空间优化为一维数组，
// dp[j] = dp[j]（上方）+ dp[j-1]（左方）。
//
// 时间复杂度: O(m * n)
// 空间复杂度: O(n)
