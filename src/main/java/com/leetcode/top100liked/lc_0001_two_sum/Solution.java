package com.leetcode.top100liked.lc_0001_two_sum;

import java.util.HashMap;

/**
 * LeetCode 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值
 * target 的那两个整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案，
 * 并且你不能使用两次相同的元素。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // 获取数组的长度
        int n = nums.length;

        // 创建一个哈希表（键为数值，值为该数值对应的索引）
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历数组中的每一个元素
        for (int i = 0; i < n; i++) {
            // 计算当前数对应的“目标差值”
            // 如果 target = 9，当前数是 2，那么我们需要找 9 - 2 = 7
            int complement = target - nums[i];

            // 判断哈希表中是否已经存在这个“目标差值”
            if (map.containsKey(complement)) {
                // 如果存在，说明我们找到了两个数的和等于 target
                // 返回这两个数的下标（哈希表中记录的索引 和 当前索引）
                return new int[]{map.get(complement), i};
            }

            // 如果没有找到，就把当前数值和它的索引存入哈希表
            map.put(nums[i], i);
        }

        // 如果遍历结束还没有找到符合条件的两个数，返回空数组
        return new int[]{};
    }
}

// 核心思路
// 利用哈希表存储已遍历元素的值和下标。对于当前元素 nums[i]，
// 若 target - nums[i] 已存在于哈希表中，则找到答案。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)

