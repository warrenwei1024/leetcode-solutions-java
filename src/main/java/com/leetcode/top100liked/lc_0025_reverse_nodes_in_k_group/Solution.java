package com.leetcode.top100liked.lc_0025_reverse_nodes_in_k_group;

/**
 * LeetCode 25. K 个一组翻转链表
 * <p>
 * 给你链表的头节点 head，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
 * 那么请将最后剩余的节点保持原有顺序。不能只是改变节点内部的值，而是需要实际进行节点交换。
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        // 虚拟头节点，简化边界处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            // 检查剩余节点是否足够 k 个
            ListNode check = prev;
            for (int i = 0; i < k; i++) {
                check = check.next;
                if (check == null) {
                    return dummy.next;    // 不足 k 个，返回结果
                }
            }

            // 翻转 [prev.next, check] 范围内的 k 个节点
            ListNode start = prev.next;         // 本组第一个节点（翻转后变末尾）
            ListNode nextGroupHead = check.next; // 下一组的头节点

            // 翻转当前组
            ListNode curr = start;
            ListNode tempPrev = nextGroupHead;  // 翻转后 start 的 next 指向下一组
            while (curr != nextGroupHead) {
                ListNode nextNode = curr.next;
                curr.next = tempPrev;
                tempPrev = curr;
                curr = nextNode;
            }

            // 将翻转后的组连接到前面的链表上
            prev.next = tempPrev;    // tempPrev 现在是翻转后本组的头节点
            prev = start;            // start 现在是本组末尾，作为下一组的前驱
        }
    }
}

// 核心思路
// 迭代法 + 分组翻转。用 dummy 头简化边界，prev 指向前一组末尾。
// 每轮先检查剩余是否够 k 个，不够则直接返回。翻转时维护 4 个关键指针：
// prev（前组末尾）、start（本组头，翻转后变尾）、check（本组尾）、nextGroupHead（下一组头）。
// 翻转后 prev.next = 新头，prev 移到 start 继续下一组。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
