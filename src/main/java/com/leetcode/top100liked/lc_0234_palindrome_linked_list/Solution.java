package com.leetcode.top100liked.lc_0234_palindrome_linked_list;

/**
 * LeetCode 234. 回文链表
 * <p>
 * 给你一个单链表的头节点 head，请你判断该链表是否为回文链表。
 * 如果是，返回 true；否则，返回 false。
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // 空链表或只有一个节点，是回文
        }

        // 步骤 1: 快慢指针找到链表的中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 步骤 2: 反转后半部分链表
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // 步骤 3: 比较两部分
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // 反转链表的辅助函数
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

// 核心思路
// 快慢指针找中点，反转后半部分链表，然后双指针比较前后两部分。
// 回文链表的正序和逆序相同，反转后半部分后逐一比较即可。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
