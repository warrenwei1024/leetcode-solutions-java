package com.leetcode.top100liked.lc_0035_search_insert_position;

/**
 * LeetCode 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;    // 注意：右边界为数组长度，而非 length-1

        // 二分查找，寻找第一个 >= target 的位置
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid;        // 目标在左半部分（含 mid）
            } else {
                left = mid + 1;     // 目标在右半部分
            }
        }

        // left 即为插入位置
        return left;
    }
}

// 核心思路
// 标准二分查找变体：寻找第一个大于等于 target 的位置。
// 右边界初始化为 nums.length 以处理插入到末尾的情况。
//
// 时间复杂度: O(log n)
// 空间复杂度: O(1)
