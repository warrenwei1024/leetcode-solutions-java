package com.leetcode.top100liked.lc_0034_find_first_and_last_position_of_element_in_sorted_array;

/**
 * LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 要求时间复杂度 O(log n)。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        // 边界处理
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // 分别查找左边界和右边界
        int left = findLeft(nums, target);
        int right = findRight(nums, target);

        return new int[]{left, right};
    }

    /**
     * 查找 target 的最左边界
     */
    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                // 即使找到 target，仍向左搜索看是否有更早的出现位置
                right = mid - 1;
                if (nums[mid] == target) {
                    result = mid;
                }
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    /**
     * 查找 target 的最右边界
     */
    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                // 即使找到 target，仍向右搜索看是否有更晚的出现位置
                left = mid + 1;
                if (nums[mid] == target) {
                    result = mid;
                }
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

// 核心思路
// 两次二分查找：分别找左边界和右边界。
// 找左边界时，即使 nums[mid] == target 也继续向左搜索 (right = mid - 1)。
// 找右边界时，即使 nums[mid] == target 也继续向右搜索 (left = mid + 1)。
//
// 时间复杂度: O(log n)
// 空间复杂度: O(1)
