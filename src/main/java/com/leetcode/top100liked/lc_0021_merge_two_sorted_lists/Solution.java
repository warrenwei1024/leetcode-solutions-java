package com.leetcode.top100liked.lc_0021_merge_two_sorted_lists;

/**
 * LeetCode 21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的升序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 创建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 迭代合并两个有序链表
        while (list1 != null && list2 != null) {
            // 选择较小的节点
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            // 移动当前指针
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;

        return dummy.next;
    }
}

// 核心思路
// 使用虚拟头节点，同时遍历两个链表，每次取较小值的节点接到结果链表尾部。
// 最后将剩余链表直接拼接。
//
// 时间复杂度: O(m + n)
// 空间复杂度: O(1)
