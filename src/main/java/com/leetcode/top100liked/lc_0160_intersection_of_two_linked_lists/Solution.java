package com.leetcode.top100liked.lc_0160_intersection_of_two_linked_lists;

/**
 * LeetCode 160. 相交链表
 * <p>
 * 给你两个单链表的头节点 headA 和 headB，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;


        ListNode pA = headA;
        ListNode pB = headB;

        while(pA != pB) {
            if(pA == null){
                pA = headB;
            }else {
                pA = pA.next;
            }
            if(pB == null){
                pB = headA;
            }else{
                pB = pB.next;
            }
        }
        return pA;
    }
}

// 核心思路
// 双指针遍历：pA 遍历完 A 后指向 B，pB 遍历完 B 后指向 A。
// 若相交，两指针会在交点相遇（走过的总路程相同）；若不相交，同时为 null。
//
// 时间复杂度: O(m + n)
// 空间复杂度: O(1)
//
// 方法二：计算长度差值，对齐后同步遍历
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) return null;
//
//        // 1. 计算长度
//        int lenA = getLength(headA);
//        int lenB = getLength(headB);
//
//        // 2. 对齐起点
//        ListNode pA = headA;
//        ListNode pB = headB;
//
//        if (lenA > lenB) {
//            for (int i = 0; i < lenA - lenB; i++) {
//                pA = pA.next;
//            }
//        } else {
//            for (int i = 0; i < lenB - lenA; i++) {
//                pB = pB.next;
//            }
//        }
//
//        // 3. 同步寻找交点
//        while (pA != pB) {
//            pA = pA.next;
//            pB = pB.next;
//        }
//
//        return pA;
//    }
//
//    private int getLength(ListNode head) {
//        int length = 0;
//        while (head != null) {
//            length++;
//            head = head.next;
//        }
//        return length;
//    }
//}
