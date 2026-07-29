package com.leetcode.top100liked.lc_0279_perfect_squares;

/**
 * LeetCode 279. 完全平方数
 * <p>
 * 给你一个整数 n，返回和为 n 的完全平方数的最少数量。
 * 完全平方数是一个整数，其值等于另一个整数的平方；可重复使用。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public int numSquares(int n) {
        // dp[i] 表示凑齐整数 i 所需的最少完全平方数个数
        int[] dp = new int[n + 1];

        // 初始化 dp 数组，因为最多用 n 个 1 相加，所以初始化为 i 即可
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        // dp[0] 默认就是 0

        // 外层循环遍历每一个数字 i
        for (int i = 1; i <= n; i++) {
            // 内层循环遍历所有可能的完全平方数 j*j
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}

// 核心思路
// 动态规划：dp[i] 表示凑齐整数 i 所需的最少完全平方数个数。
// 状态转移：dp[i] = min(dp[i - j*j] + 1)，枚举所有 j 满足 j*j <= i。
//
// 时间复杂度: O(n * sqrt(n))
// 空间复杂度: O(n)
