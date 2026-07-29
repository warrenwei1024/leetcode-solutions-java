package com.leetcode.top100liked.lc_0189_rotate_array;

/**
 * LeetCode 189. 轮转数组
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length <=1) {
            return;
        }

        int n = nums.length;
        // 1. 处理 k 大于数组长度的情况
        k = k % n;

        // 2. 翻转整个数组
        reverse(nums, 0, n - 1);

        // 3. 翻转前 k 个元素
        reverse(nums, 0, k - 1);

        // 4. 翻转剩下的元素
        reverse(nums, k, n - 1);

    }


    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

// 核心思路
// 三次翻转：先翻转整个数组，再翻转前 k 个元素，最后翻转剩余元素。
// 注意先对 k 取模处理 k > n 的情况。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
