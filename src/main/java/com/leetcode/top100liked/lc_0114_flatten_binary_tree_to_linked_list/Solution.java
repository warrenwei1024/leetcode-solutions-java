package com.leetcode.top100liked.lc_0114_flatten_binary_tree_to_linked_list;

/**
 * LeetCode 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode，其中 right 子指针指向链表中下一个结点，
 * 而 left 子指针始终为 null。展开后的单链表应该与二叉树先序遍历顺序相同。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 后序遍历变体：右 → 左 → 根
        // 递归时从最后一个节点开始向前串联
        flatten(root.right);
        flatten(root.left);

        // 将当前节点的右指针指向前一个处理节点
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

// 核心思路
// 采用"右 → 左 → 根"的遍历顺序（后序遍历的镜像），从最后一个节点逆向串联。
// 用 prev 记录上一个处理节点，当前节点 root.right = prev，root.left = null。
// 这种方式保证了展开后的链表与前序遍历顺序一致。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h)，h 为树高，递归栈空间
