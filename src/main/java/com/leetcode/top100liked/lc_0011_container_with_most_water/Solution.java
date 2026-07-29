package com.leetcode.top100liked.lc_0011_container_with_most_water;

/**
 * LeetCode 11. 盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组 height，有 n 条垂线，找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    /**
     * 使用双指针法求解盛最多水的容器
     * @param height 表示每条垂直线高度的数组
     * @return 容器可以储存的最大水量
     */
    public int maxArea(int[] height) {
        // 边界检查
        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0; // 左指针，从数组开头开始
        int right = height.length - 1; // 右指针，从数组末尾开始
        int maxArea = 0; // 用于记录最大水量

        // 当左指针小于右指针时，持续搜索
        while (left < right) {
            // 计算当前指针位置构成的容器水量
            // 宽度：right - left
            // 高度：两条线中较短的一条，即 Math.min(height[left], height[right])
            int currentArea = (right - left) * Math.min(height[left], height[right]);

            // 更新最大水量
            maxArea = Math.max(maxArea, currentArea);

            // 移动较短边对应的指针
            // 这是算法的关键：只有移动短边，才有可能在宽度减小的情况下，通过增加高度来获得更大的面积
            if (height[left] < height[right]) {
                left++; // 左边较短，移动左指针
            } else {
                right--; // 右边较短（或相等），移动右指针
            }
        }

        return maxArea;
    }

    // --- 测试代码 ---
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("输入: " + java.util.Arrays.toString(height1));
        System.out.println("输出: " + solution.maxArea(height1)); // 期望输出: 49
        System.out.println();

        // 测试用例2
        int[] height2 = {1, 1};
        System.out.println("输入: " + java.util.Arrays.toString(height2));
        System.out.println("输出: " + solution.maxArea(height2)); // 期望输出: 1
        System.out.println();

        // 测试用例3
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("输入: " + java.util.Arrays.toString(height3));
        System.out.println("输出: " + solution.maxArea(height3)); // 期望输出: 16
    }
}

// 核心思路
// 双指针从两端向中间收缩，每次移动较短的边。
// 因为面积由较短边决定，移动短边才有可能在宽度减小的同时获得更大的高度。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
