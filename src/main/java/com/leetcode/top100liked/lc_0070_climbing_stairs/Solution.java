package com.leetcode.top100liked.lc_0070_climbing_stairs;

/**
 * LeetCode 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        // dp[i] 表示爬到第 i 阶的方法数
        // 状态转移：dp[i] = dp[i-1] + dp[i-2]（斐波那契数列）
        // 空间优化：只用两个变量
        int prev2 = 1;   // dp[i-2]，爬到第 1 阶有 1 种方法
        int prev1 = 2;   // dp[i-1]，爬到第 2 阶有 2 种方法

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

// 核心思路
// 动态规划，本质是斐波那契数列。dp[i] = dp[i-1] + dp[i-2]：
// 从 i-1 爬 1 阶或从 i-2 爬 2 阶到达第 i 阶。
// 空间优化为 O(1)，只用两个变量滚动更新。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
