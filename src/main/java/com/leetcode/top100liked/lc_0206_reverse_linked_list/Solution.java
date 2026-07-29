package com.leetcode.top100liked.lc_0206_reverse_linked_list;

/**
 * LeetCode 206. 反转链表
 * <p>
 * 给你单链表的头节点 head，请你反转链表，并返回反转后的链表。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */


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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}

// 核心思路
// 迭代法：用 prev、curr、next 三个指针遍历链表，逐个反转节点的指向。
// curr.next = prev 后，三指针同步前移。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
