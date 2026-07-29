package com.leetcode.top100liked.lc_0239_sliding_window_maximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode 239. 滑动窗口最大值
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字，返回滑动窗口中的最大值。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    /**
     * 给定一个整数数组 nums 和一个滑动窗口大小 k，
     * 返回每个滑动窗口中的最大值。
     *
     * 使用双端队列（Deque）维护一个单调递减队列：
     * - 队列中存储的是数组下标；
     * - 队首始终是当前窗口的最大值的下标；
     * - 当窗口滑动时，移除超出窗口范围的元素；
     * - 在加入新元素前，从队尾移除所有小于当前元素的值（因为它们不可能成为最大值）。
     *
     * 时间复杂度：O(n)，每个元素最多入队和出队一次。
     * 空间复杂度：O(k)，双端队列最多保存 k 个元素。
     *
     * @param nums 输入数组
     * @param k 滑动窗口大小
     * @return 每个窗口的最大值组成的数组
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>(); // 存储下标，维护单调递减
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            // 移除队首超出窗口范围的元素（窗口左边界为 i - k + 1）
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 从队尾移除所有小于当前元素 nums[i] 的下标（保持单调递减）
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 将当前下标加入队尾
            deque.offerLast(i);

            // 当窗口形成后（i >= k - 1），记录当前窗口最大值
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // 测试方法
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        // 输出: [3, 3, 5, 5, 6, 7]

        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1}, 1)));
        // 输出: [1]

        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, -1}, 1)));
        // 输出: [1, -1]

        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{9, 11}, 2)));
        // 输出: [11]

        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{4, -2}, 2)));
        // 输出: [4]
    }
}

// 核心思路
// 单调递减双端队列：队列存储下标，队首始终为当前窗口最大值的下标。
// 每次新元素入队前，从队尾弹出所有小于它的元素以保持单调性。
//
// 时间复杂度: O(n)
// 空间复杂度: O(k)