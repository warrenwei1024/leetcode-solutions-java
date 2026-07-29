package com.leetcode.top100liked.lc_0041_first_missing_positive;

/**
 * LeetCode 41. 缺失的第一个正数
 * <p>
 * 给你一个未排序的整数数组 nums，请你找出其中没有出现的最小的正整数。
 * 你必须实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public int firstMissingPositive(int[] nums){

        int n = nums.length;

        // 1. 第一遍遍历：尝试让每个满足条件的数字“回到它自己的家”
        for(int i = 0; i<n; i++){
            // 只有当 nums[i] 在 [1, n] 范围内，且它不在它该在的位置上时，才进行交换
            // 注意：nums[i] 应该去的索引是 nums[i] - 1
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                // 交换 nums[i] 和 nums[nums[i] - 1]
                swap(nums, i, nums[i] - 1);
            }
        }

        // 2. 第二遍遍历：寻找第一个没有各就各位的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // 发现不匹配，i + 1 就是缺失的第一个正数
            }
        }

        // 3. 如果所有数字都各就各位了（例如数组是 [1, 2, 3]），那么答案就是 n + 1
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 核心思路
// 原地哈希：将每个在 [1, n] 范围内的数 x 放到索引 x-1 的位置上。
// 遍历调整后的数组，第一个 nums[i] != i+1 的位置即答案；否则答案为 n+1。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
