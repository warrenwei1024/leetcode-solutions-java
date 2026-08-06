package com.leetcode.top100liked.lc_0295_find_median_from_data_stream;

/**
 * LeetCode 295. 数据流的中位数
 * <p>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，中位数是中间两个数的平均值。
 * 实现 MedianFinder 类：addNum(int num) 将数据流中的整数添加到数据结构中，
 * findMedian() 返回目前所有元素的中位数。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.PriorityQueue;

public class Solution {

    static class MedianFinder {

        // 最大堆（存较小的一半元素），堆顶是最大值
        private PriorityQueue<Integer> maxHeap;
        // 最小堆（存较大的一半元素），堆顶是最小值
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            // maxHeap 需要最大堆，Java 默认最小堆，用 (a,b) -> b-a 反转
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 保证 maxHeap 中的元素 ≤ minHeap 中的元素
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // 平衡两个堆的大小：maxHeap 的大小 == minHeap 或 minHeap + 1
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                // 奇数个元素，中位数为 maxHeap 堆顶
                return maxHeap.peek();
            } else {
                // 偶数个元素，中位数为两堆顶的平均值
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }
}

// 核心思路
// 双堆法：用最大堆存较小的一半，最小堆存较大的一半。
// addNum：先根据大小决定放入哪个堆，再平衡两个堆的大小。
// 平衡规则：maxHeap.size() == minHeap.size() 或 minHeap.size() + 1。
// findMedian：奇数个取 maxHeap 堆顶，偶数个取两堆顶平均值。
//
// addNum 时间复杂度: O(log n)
// findMedian 时间复杂度: O(1)
// 空间复杂度: O(n)
