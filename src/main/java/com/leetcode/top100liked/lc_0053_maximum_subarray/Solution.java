package com.leetcode.top100liked.lc_0053_maximum_subarray;

/**
 * LeetCode 53. 最大子数组和
 * <p>
 * 给你一个整数数组 nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        if(n == 0) return 0;

        // dp[i] 表示以 nums[i] 结尾的最大子数组和
        int[] dp = new int[n];

        // 初始化
        dp[0] = nums[0];
        int maxSum = dp[0];

        for(int i = 1; i<n; i++){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}

// 核心思路
// Kadane 算法（动态规划）：dp[i] 表示以 nums[i] 结尾的最大子数组和。
// 状态转移：dp[i] = max(nums[i], dp[i-1] + nums[i])，即要么另起炉灶，要么延续前序。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)

// 优化：使用滚动变量替代 dp 数组，空间复杂度可降至 O(1)。
// 定义 currentSum 表示以当前元素结尾的最大子数组和，maxSum 表示全局最大值。
// 对于每个元素 nums[i]，两个选择：加入之前的子数组或从当前元素重新开始。
// currentSum = Math.max(nums[i], currentSum + nums[i])，更新 maxSum。
//
// class Solution {
//     public int maxSubArray(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         int currentSum = nums[0];
//         int maxSum = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             currentSum = Math.max(nums[i], currentSum + nums[i]);
//             maxSum = Math.max(maxSum, currentSum);
//         }
//         return maxSum;
//     }
// }
