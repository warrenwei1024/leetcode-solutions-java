package com.leetcode.top100liked.lc_0023_merge_k_sorted_lists;

/**
 * LeetCode 23. 合并 K 个升序链表
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 最小堆，按节点值排序
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 将所有链表的头节点入堆
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        // 虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 每次从堆中取出最小节点，链接到结果链表
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            tail.next = minNode;
            tail = tail.next;

            // 如果该节点还有后续，将其入堆
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}

// 核心思路
// 最小堆（优先队列）法。将所有链表头节点放入最小堆，
// 每次弹出最小节点链接到结果链表中，再将该节点的 next 入堆。
// 也可用分治法：两两合并链表（类似归并排序），递归合并。
//
// 时间复杂度: O(N log k)，N 为总节点数，k 为链表数
// 空间复杂度: O(k)，堆中最多 k 个元素
