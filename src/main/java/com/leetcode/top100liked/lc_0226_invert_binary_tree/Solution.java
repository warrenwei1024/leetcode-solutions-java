package com.leetcode.top100liked.lc_0226_invert_binary_tree;

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
 * LeetCode 226. 翻转二叉树
 * <p>
 * 给你一棵二叉树的根节点 root，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 1. 交换当前节点的左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 2. 递归翻转左子树（原来的右子树）
        invertTree(root.left);

        // 3. 递归翻转右子树（原来的左子树）
        invertTree(root.right);

        return root;

    }
}

// 核心思路
// 递归：交换当前节点的左右子树，然后递归翻转左右子树。
// 先序遍历和后序遍历均可，关键是交换 + 递归的顺序。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h) —— 递归栈深度
