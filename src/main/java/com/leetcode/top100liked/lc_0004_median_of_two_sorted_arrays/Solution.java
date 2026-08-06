package com.leetcode.top100liked.lc_0004_median_of_two_sorted_arrays;

/**
 * LeetCode 4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的中位数。要求时间复杂度 O(log(m+n))。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短数组，减少二分次数
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;    // 左半部分元素个数

        // 在 nums1 上二分，确定划分位置
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;   // nums1 左半元素数
            int j = totalLeft - i;                     // nums2 左半元素数

            if (nums1[i - 1] <= nums2[j]) {
                // i 可能还可以更大
                left = i;
            } else {
                right = i - 1;
            }
        }

        int i = left;
        int j = totalLeft - i;

        // 左半部分最大值
        int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
        int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
        int leftMax = Math.max(nums1LeftMax, nums2LeftMax);

        // 右半部分最小值
        int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
        int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
        int rightMin = Math.min(nums1RightMin, nums2RightMin);

        // 总数为奇数：中位数为左半最大值；偶数：左右均值
        if ((m + n) % 2 == 1) {
            return leftMax;
        } else {
            return (leftMax + rightMin) / 2.0;
        }
    }
}

// 核心思路
// 二分法划分数组。将两数组各切分为左右两部分，使得：
// 1. 左半总元素数 = (m+n+1)/2，保证左半 ≥ 右半
// 2. 左半所有元素 ≤ 右半所有元素
// 在较短数组上二分查找满足条件的划分点 i，j = totalLeft - i。
// 中位数：奇数个取左半最大值，偶数个取左右均值。
//
// 时间复杂度: O(log(min(m, n)))
// 空间复杂度: O(1)
