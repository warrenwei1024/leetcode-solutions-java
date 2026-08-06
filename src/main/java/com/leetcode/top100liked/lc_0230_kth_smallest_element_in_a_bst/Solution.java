package com.leetcode.top100liked.lc_0230_kth_smallest_element_in_a_bst;

/**
 * LeetCode 230. 二叉搜索树中第 K 小的元素
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个整数 k，请你设计一个算法查找其中第 k 小的元素。
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

    private int rank = 0;       // 当前遍历到的排名
    private int result = 0;     // 第 k 小的元素值

    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历 BST，第 k 个访问的节点即为答案
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // 左子树
        inorder(node.left, k);

        // 当前节点
        rank++;
        if (rank == k) {
            result = node.val;
            return;
        }

        // 右子树
        inorder(node.right, k);
    }
}

// 核心思路
// BST 的中序遍历天然有序。中序遍历过程中计数，第 k 个访问的节点即为所求。
// 利用全局计数器 rank，当 rank == k 时记录结果。
//
// 时间复杂度: O(k)，最坏 O(n)
// 空间复杂度: O(h)，h 为树高，递归栈空间
