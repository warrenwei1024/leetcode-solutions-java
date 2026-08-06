package com.leetcode.top100liked.lc_0198_house_robber;

/**
 * LeetCode 198. 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下，
 * 一夜之内能够偷窃到的最高金额。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i] 表示偷到第 i 间房时的最大金额
        // 状态转移：偷当前房间 = dp[i-2] + nums[i]，不偷 = dp[i-1]
        // 空间优化为两个变量
        int prev2 = nums[0];                        // dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]);     // dp[i-1]

        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

// 核心思路
// 动态规划：dp[i] = max(dp[i-1], dp[i-2] + nums[i])。
// 对第 i 间房：要么不偷（延续 dp[i-1]），要么偷（加上 dp[i-2] 和当前金额）。
// 空间优化只用两个变量滚动。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
