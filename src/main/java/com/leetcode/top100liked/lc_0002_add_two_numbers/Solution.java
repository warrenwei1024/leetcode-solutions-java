package com.leetcode.top100liked.lc_0002_add_two_numbers;

/**
 * LeetCode 2. 两数相加
 * <p>
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。请你将两个数相加，并以相同形式返回一个表示和的链表。
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        // 当前处理的节点
        ListNode cur = dummy;
        int carry = 0;  // 存储进位

        // 遍历两个链表
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;    // 初始化sum为进位

            // 如果l1不为空，取l1的当前值
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // 如果l2不为空，取l2的当前值
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 更新进位
            carry = sum / 10;

            // 创建一个新的节点，存储当前位的值
            cur.next = new ListNode(sum % 10);

            // 移动指针到新的节点
            cur = cur.next;
        }

        // 返回虚拟头节点的下一个节点，即结果链表的头
        return dummy.next;
    }
}

// 核心思路
// 模拟加法运算，同时遍历两个链表，逐位相加并处理进位。
// 使用虚拟头节点简化边界处理，最后若还有进位则追加一个节点。
//
// 时间复杂度: O(max(m, n))
// 空间复杂度: O(1) —— 不计结果链表
