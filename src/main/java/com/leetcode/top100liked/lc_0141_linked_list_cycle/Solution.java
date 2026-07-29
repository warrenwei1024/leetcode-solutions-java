package com.leetcode.top100liked.lc_0141_linked_list_cycle;

/**
 * LeetCode 141. 环形链表
 * <p>
 * 给你一个链表的头节点 head，判断链表中是否有环。
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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;  // 空链表或只有一个节点，不可能有环
        }

        ListNode slow = head;
        ListNode fast = head;

        // 快慢指针同时向前走，快指针走两步，慢指针走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;           // 慢指针走一步
            fast = fast.next.next;      // 快指针走两步

            if (slow == fast) {         // 如果相遇，说明有环
                return true;
            }
        }

        // 如果快指针到达 null，则链表没有环
        return false;
    }
}

// 核心思路
// 快慢指针（Floyd 判圈算法）：慢指针每次走一步，快指针每次走两步。
// 如果有环，快慢指针必然相遇；如果无环，快指针会先到达 null。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
