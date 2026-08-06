package com.leetcode.top100liked.lc_0031_next_permutation;

/**
 * LeetCode 31. 下一个排列
 * <p>
 * 整数数组的一个排列就是将其所有成员以序列或线性顺序排列。
 * 给你一个整数数组 nums，找出 nums 的下一个排列。必须原地修改，只允许使用额外常数空间。
 * 下一个排列是指其整数的下一个字典序更大的排列。如果不存在下一个更大的排列，
 * 则将数组重新排列成字典序最小的排列（即升序排列）。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int n = nums.length;

        // 1. 从右向左找第一个升序对 nums[i] < nums[i+1]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 2. 从右向左找第一个大于 nums[i] 的元素 nums[j]
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            // 3. 交换 nums[i] 和 nums[j]
            swap(nums, i, j);
        }

        // 4. 反转 i+1 到末尾的部分（使其变为升序）
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

// 核心思路
// 1. 从右向左找第一个 nums[i] < nums[i+1] 的位置 i
// 2. 从右向左找第一个大于 nums[i] 的元素 nums[j]，交换
// 3. 反转 i+1 到末尾（原为降序，反转为升序即得下一个字典序排列）
// 若不存在 i（全降序），直接反转整个数组得到最小排列。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
