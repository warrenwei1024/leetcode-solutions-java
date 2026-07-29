package com.leetcode.top100liked.lc_0104_maximum_depth_of_binary_tree;

//Definition for a binary tree node.
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

/**
 * LeetCode 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树 root，返回其最大深度。
 * 二叉树的最大深度是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// 核心思路
// 递归：树的最大深度 = max(左子树深度, 右子树深度) + 1。
// 空节点深度为 0，递归到叶子节点后逐层回溯累加。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h) —— 递归栈深度
