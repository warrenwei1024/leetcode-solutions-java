package com.leetcode.top100liked.lc_0215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;

/**
 * LeetCode 215. 数组中的第K个最大元素
 * <p>
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {

        // 创建最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            // 如果堆的大小超过 k，移除最小的元素（堆顶）
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 堆顶即为第 k 大的元素
        return minHeap.peek();

    }
}

// 核心思路
// 小顶堆：维护大小为 k 的最小堆，遍历数组时将元素入堆，
// 堆大小超过 k 时弹出堆顶（最小值），最终堆顶即为第 k 大的元素。
//
// 时间复杂度: O(n log k)
// 空间复杂度: O(k)
