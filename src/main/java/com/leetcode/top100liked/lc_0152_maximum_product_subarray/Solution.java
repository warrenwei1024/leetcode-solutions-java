package com.leetcode.top100liked.lc_0152_maximum_product_subarray;

/**
 * LeetCode 152. 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 同时维护以当前位置结尾的最大乘积和最小乘积
        int maxSoFar = nums[0];   // 全局最大乘积
        int maxEnding = nums[0];  // 以当前元素结尾的最大乘积
        int minEnding = nums[0];  // 以当前元素结尾的最小乘积（处理负数翻转）

        for (int i = 1; i < nums.length; i++) {
            // 遇到负数时，最大和最小会互换
            if (nums[i] < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            // 状态转移：要么接在前面的乘积后面，要么从当前元素重新开始
            maxEnding = Math.max(nums[i], maxEnding * nums[i]);
            minEnding = Math.min(nums[i], minEnding * nums[i]);

            maxSoFar = Math.max(maxSoFar, maxEnding);
        }

        return maxSoFar;
    }
}

// 核心思路
// 动态规划，同时维护最大和最小乘积（因为负数乘以最小可能变最大）。
// 遇到负数时先交换 maxEnding 和 minEnding。
// maxEnding = max(nums[i], maxEnding * nums[i]) → 接续或重开。
// minEnding = min(nums[i], minEnding * nums[i]) → 同理。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
