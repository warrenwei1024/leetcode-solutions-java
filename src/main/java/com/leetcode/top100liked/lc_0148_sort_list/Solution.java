package com.leetcode.top100liked.lc_0148_sort_list;

/**
 * LeetCode 148. 排序链表
 * <p>
 * 给你链表的头结点 head，请将其按升序排列并返回排序后的链表。
 * 要求 O(n log n) 时间复杂度和 O(1) 空间复杂度。
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

    // ======================== 方法一：自顶向下递归归并 ========================
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 快慢指针找中点，断链
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // 2. 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3. 合并两个有序链表
        return merge(left, right);
    }

    /**
     * 快慢指针找链表中点（靠左），当双数节点时返回靠左的中点
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;  // fast 先多走一步，确保偶数时 slow 落在左中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 合并两个有序链表，返回合并后的头节点
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;

        return dummy.next;
    }
}

// 核心思路
// 归并排序（自顶向下递归）：快慢指针找中点断链，递归排序左右两部分，
// 然后合并两个有序链表。也可用自底向上迭代实现 O(1) 空间。
//
// 时间复杂度: O(n log n)
// 空间复杂度: O(log n) —— 递归栈深度

// ======================== 方法二：自底向上迭代归并 (O(1)空间) ========================
// public class Solution {
//     public ListNode sortList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//
//         // 1. 计算链表长度
//         int length = 0;
//         ListNode node = head;
//         while (node != null) {
//             length++;
//             node = node.next;
//         }
//
//         // 2. 自底向上归并排序
//         ListNode dummy = new ListNode(0, head);
//
//         // step 表示每次归并的子链表长度，从 1 开始，每次翻倍
//         for (int step = 1; step < length; step <<= 1) {
//             ListNode prev = dummy;          // 已排序部分的尾节点
//             ListNode cur = dummy.next;      // 当前待处理节点
//
//             while (cur != null) {
//                 // 取出第一个子链表（长度 step）
//                 ListNode left = cur;
//                 ListNode right = split(left, step);
//
//                 // 取出第二个子链表（长度 step），并更新 cur
//                 cur = split(right, step);
//
//                 // 合并两个子链表，并将合并后的链表接到 prev 后面
//                 prev.next = merge(left, right);
//
//                 // 将 prev 移动到合并后链表的末尾
//                 while (prev.next != null) {
//                     prev = prev.next;
//                 }
//             }
//         }
//
//         return dummy.next;
//     }
//
//     /**
//      * 将链表从 head 开始，切出前 len 个节点，返回剩余部分的头节点
//      */
//     private ListNode split(ListNode head, int len) {
//         if (head == null) {
//             return null;
//         }
//         for (int i = 1; i < len && head.next != null; i++) {
//             head = head.next;
//         }
//         ListNode next = head.next;
//         head.next = null;   // 断开连接
//         return next;
//     }
//
//     /**
//      * 合并两个有序链表，返回合并后的头节点
//      */
//     private ListNode merge(ListNode left, ListNode right) {
//         ListNode dummy = new ListNode(0);
//         ListNode cur = dummy;
//
//         while (left != null && right != null) {
//             if (left.val < right.val) {
//                 cur.next = left;
//                 left = left.next;
//             } else {
//                 cur.next = right;
//                 right = right.next;
//             }
//             cur = cur.next;
//         }
//         cur.next = left != null ? left : right;
//
//         return dummy.next;
//     }
// }
