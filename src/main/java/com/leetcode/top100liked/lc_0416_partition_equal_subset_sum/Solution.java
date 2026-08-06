package com.leetcode.top100liked.lc_0416_partition_equal_subset_sum;

/**
 * LeetCode 416. 分割等和子集
 * <p>
 * 给你一个只包含正整数的非空数组 nums。请你判断是否可以将这个数组分割成两个子集，
 * 使得两个子集的元素和相等。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 总和为奇数，不可能等分
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        // dp[i] 表示能否选出和为 i 的子集（0/1 背包）
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;   // 和为 0 总是可以（不选任何元素）

        for (int num : nums) {
            // 从后往前遍历，确保每个元素只用一次（0/1 背包）
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }

            // 提前终止：已经可以组成 target
            if (dp[target]) {
                return true;
            }
        }

        return dp[target];
    }
}

// 核心思路
// 转化为 0/1 背包问题：能否选出若干元素使其和为 totalSum/2。
// dp[j] 表示能否选出和为 j 的子集。遍历每个 num，从后向前更新 dp。
// dp[j] = dp[j] || dp[j - num]（不选或选当前元素）。
//
// 时间复杂度: O(n * target)
// 空间复杂度: O(target)
