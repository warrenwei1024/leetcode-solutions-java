package com.leetcode.top100liked.lc_0033_search_in_rotated_sorted_array;

/**
 * LeetCode 33. 搜索旋转排序数组
 * <p>
 * 整数数组 nums 按升序排列，数组中的值互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转。
 * 给你旋转后的数组 nums 和一个整数 target，如果 nums 中存在这个目标值 target，
 * 则返回它的索引，否则返回 -1。要求时间复杂度 O(log n)。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 判断哪一半是有序的
            if (nums[left] <= nums[mid]) {
                // 左半部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    // target 在左半有序区间内
                    right = mid - 1;
                } else {
                    // target 在右半部分
                    left = mid + 1;
                }
            } else {
                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    // target 在右半有序区间内
                    left = mid + 1;
                } else {
                    // target 在左半部分
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

// 核心思路
// 旋转后的数组一半有序、一半无序。每次二分先判断 mid 落在哪一半：
// 若左半有序：判断 target 是否在 [left, mid) 中决定去哪边搜索。
// 若右半有序：判断 target 是否在 (mid, right] 中决定去哪边搜索。
// 关键在于始终利用有序的那一半来判断 target 的位置。
//
// 时间复杂度: O(log n)
// 空间复杂度: O(1)
