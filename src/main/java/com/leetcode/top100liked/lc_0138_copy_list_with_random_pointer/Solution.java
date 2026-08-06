package com.leetcode.top100liked.lc_0138_copy_list_with_random_pointer;

/**
 * LeetCode 138. 随机链表的复制
 * <p>
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random，
 * 该指针可以指向链表中的任何节点或空节点。构造这个链表的深拷贝。
 * 深拷贝应该正好由 n 个全新节点组成，每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 第一趟：在每个原节点后面插入其拷贝节点
        // A → A' → B → B' → C → C'
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 第二趟：设置拷贝节点的 random 指针
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // 拷贝节点的 random = 原节点 random 的拷贝
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 第三趟：拆分链表，恢复原链表并提取拷贝链表
        Node dummy = new Node(0);
        Node copyTail = dummy;
        curr = head;

        while (curr != null) {
            Node copy = curr.next;        // 拷贝节点
            copyTail.next = copy;
            copyTail = copy;

            // 恢复原链表的 next
            curr.next = copy.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}

// 核心思路
// 三趟扫描，O(1) 额外空间（不计输出）。
// 1. 交织：在每个原节点后插入拷贝节点（A→A'→B→B'→C→C'）
// 2. 设置 random：A'.random = A.random.next
// 3. 拆分：分离原链表和拷贝链表，恢复原链表结构
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)，不计输出链表
