package com.leetcode.top100liked.lc_0153_find_minimum_in_rotated_sorted_array;

/**
 * LeetCode 153. 寻找旋转排序数组中的最小值
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次旋转后，得到输入数组。
 * 数组中的元素互不相同。给你一个元素值互不相同的数组 nums，它原来是一个升序排列的数组，
 * 并进行了若干次旋转。请你找出并返回数组中的最小元素。
 * 要求时间复杂度 O(log n)。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 比较 mid 和最右元素：若 mid > right，最小值必在右半部分
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // nums[mid] <= nums[right]，最小值在左半部分（含 mid）
                right = mid;
            }
        }

        // left == right 时即为最小值所在位置
        return nums[left];
    }
}

// 核心思路
// 旋转数组的最小值即为"旋转点"。二分时比较 nums[mid] 和 nums[right]：
// 若 nums[mid] > nums[right]，说明旋转点在右半，left = mid + 1；
// 若 nums[mid] <= nums[right]，说明旋转点在左半（含 mid），right = mid。
// 当 left == right 时即为最小值。
//
// 时间复杂度: O(log n)
// 空间复杂度: O(1)
