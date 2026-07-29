package com.leetcode.top100liked.lc_0019_remove_nth_node_from_end_of_list;

/**
 * LeetCode 19. 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头结点，指向 head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int length = 0;
        ListNode cur = head;
        // 计算长度
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        // 我们需要找到待删除结点的前一个结点
        // 待删除结点索引为 length - n (从0开始)
        // 前一个结点索引为 length - n - 1
        // 从 dummy 开始走 length - n 步即可到达前一个结点
        int steps = length - n;
        cur = dummy;

        while (steps > 0) {
            cur = cur.next;
            steps--;
        }

        // 删除结点
        cur.next = cur.next.next;

        // 返回 dummy.next，因为它才是真正的头结点（可能已变更）
        return dummy.next;
    }
}

// 核心思路
// 先遍历一遍计算链表长度 L，则倒数第 n 个节点即正数第 L-n 个节点。
// 使用虚拟头节点简化删除头节点的边界情况，找到前驱后直接删除。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
