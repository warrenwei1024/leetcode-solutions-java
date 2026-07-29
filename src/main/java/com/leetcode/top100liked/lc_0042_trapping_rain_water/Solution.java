package com.leetcode.top100liked.lc_0042_trapping_rain_water;

/**
 * LeetCode 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，
 * 下雨之后能接多少雨水。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    /**
     * 使用双指针法求解接雨水问题。
     * 空间复杂度 O(1)，最优解。
     * @param height 表示柱子高度的数组
     * @return 能接到的雨水总量
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0; // 左指针
        int right = height.length - 1; // 右指针
        int leftMax = 0; // left 指针左侧的最大高度
        int rightMax = 0; // right 指针右侧的最大高度
        int water = 0; // 总水量

        while (left < right) {
            // 更新左右两侧的最大高度
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 核心：比较 leftMax 和 rightMax
            if (leftMax < rightMax) {
                // leftMax 较小，说明 left 位置的瓶颈在左边
                // 此时 rightMax 更大，保证了右边有墙，所以可以计算 left 位置的水量
                water += leftMax - height[left];
                left++; // 移动左指针
            } else {
                // rightMax 较小或相等，说明 right 位置的瓶颈在右边
                water += rightMax - height[right];
                right--; // 移动右指针
            }
        }

        return water;
    }
}

// 核心思路
// 双指针从两端向中间移动，维护左右两边的最大高度 leftMax 和 rightMax。
// 对于每个位置，水量由较矮的一侧决定：min(leftMax, rightMax) - height[i]。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)

