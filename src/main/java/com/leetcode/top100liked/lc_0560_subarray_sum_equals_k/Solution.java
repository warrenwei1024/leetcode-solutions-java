package com.leetcode.top100liked.lc_0560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 560. 和为 K 的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k，请你统计并返回该数组中和为 k 的连续子数组的个数。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    /**
     * 给定一个整数数组 nums 和一个整数 k，
     * 返回该数组中和为 k 的连续子数组的个数。
     *
     * 使用前缀和 + 哈希表优化：
     * 如果 prefixSum[j] - prefixSum[i] == k，则说明 [i+1, j] 区间和为 k。
     * 等价于：prefixSum[i] == prefixSum[j] - k。
     * 因此，我们可以在遍历过程中记录每个前缀和出现的次数。
     *
     * @param nums 输入数组
     * @param k 目标和
     * @return 和为 k 的连续子数组个数
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // 初始化：前缀和为0出现1次（空子数组）

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num; // 当前前缀和

            // 检查是否存在前缀和为 currentSum - k 的位置
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // 更新当前前缀和的出现次数
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    // 测试方法
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
//        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));       // 输出: 2
//        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));       // 输出: 2
//        System.out.println(solution.subarraySum(new int[]{1, -1, 0}, 0));      // 输出: 3
//        System.out.println(solution.subarraySum(new int[]{1}, 0));             // 输出: 0
//        System.out.println(solution.subarraySum(new int[]{0, 0, 0}, 0));       // 输出: 6
        System.out.println(solution.subarraySum(new int[]{1, 2, -1, 1, 2}, 3));       // 输出: 3
    }
}

// 核心思路
// 前缀和 + 哈希表：prefixSum[j] - prefixSum[i-1] = k 等价于 prefixSum[i-1] = prefixSum[j] - k。
// 遍历时用哈希表记录每个前缀和出现的次数，每次查 currentSum - k 在哈希表中的次数累加。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)