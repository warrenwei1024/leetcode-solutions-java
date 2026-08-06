package com.leetcode.top100liked.lc_0300_longest_increasing_subsequence;

/**
 * LeetCode 300. 最长递增子序列
 * <p>
 * 给你一个整数数组 nums，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.Arrays;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i] 表示以 nums[i] 结尾的最长递增子序列长度
        int[] dp = new int[nums.length];
        // 每个元素自身构成长度为 1 的子序列
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 nums[j] < nums[i]，可以接在后面
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}

// 核心思路
// 动态规划 O(n^2)：dp[i] = max(dp[j] + 1)，对所有 j < i 且 nums[j] < nums[i]。
// 每个位置向前扫描所有比它小的元素，接在后面形成更长子序列。
// 还可以用耐心排序（二分）优化到 O(n log n)，维护一个 tails 数组。
//
// 时间复杂度: O(n^2)
// 空间复杂度: O(n)
