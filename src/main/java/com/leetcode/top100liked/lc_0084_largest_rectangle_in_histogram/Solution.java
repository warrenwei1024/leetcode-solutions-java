package com.leetcode.top100liked.lc_0084_largest_rectangle_in_histogram;

/**
 * LeetCode 84. 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.Stack;

public class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 单调递增栈，存储索引
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // 在末尾添加高度 0，确保所有柱子都被处理
            int h = (i == n) ? 0 : heights[i];

            // 当前高度小于栈顶高度时，栈顶柱子的右边界确定
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                // 左边界为栈中下一个元素（或 -1 表示最左侧）
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}

// 核心思路
// 单调递增栈。对于每个柱子，找到它左右两边第一个比它低的柱子，
// 以该柱子高度为矩形高，左右边界之间的宽度为矩形宽，计算面积。
// 遍历时当前高度 < 栈顶高度 → 栈顶的右边界已确定，弹出计算。
// 末尾补 0 确保所有元素都被弹出处理。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)，栈空间
