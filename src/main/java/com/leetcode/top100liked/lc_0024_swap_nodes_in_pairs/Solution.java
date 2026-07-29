package com.leetcode.top100liked.lc_0024_swap_nodes_in_pairs;

/**
 * LeetCode 24. 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

// Definition for singly-linked list.
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
    public ListNode swapPairs(ListNode head) {
        // 1. 创建虚拟头结点，简化边界处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. 初始化 prev 指针，指向待交换对的前一个结点
        ListNode prev = dummy;

        // 3. 循环条件：确保后面至少还有两个结点
        while (prev.next != null && prev.next.next != null) {
            // 定义待交换的两个结点
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;

            // 4. 执行交换步骤
            // 步骤 A: prev 指向 node2
            prev.next = node2;

            // 步骤 B: node1 指向 node2 的下一个结点 (保留后续链表)
            node1.next = node2.next;

            // 步骤 C: node2 指向 node1 (完成交换)
            node2.next = node1;

            // 5. 移动 prev 指针到下一对的前驱 (即当前的 node1)
            prev = node1;
        }

        return dummy.next;
    }
}

// 核心思路
// 使用虚拟头节点简化边界处理，每次交换两个相邻节点：
// prev -> node1 -> node2 -> next 变为 prev -> node2 -> node1 -> next。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
