package com.leetcode.top100liked.lc_0094_binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

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
 * LeetCode 94. 二叉树的中序遍历
 * <p>
 * 给定一个二叉树的根节点 root，返回它的中序遍历。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // 1. 左
        traverse(node.left, result);
        // 2. 根
        result.add(node.val);
        // 3. 右
        traverse(node.right, result);
    }
}

// 核心思路
// 中序遍历：左 → 根 → 右。递归实现，先递归左子树，再访问当前节点，最后递归右子树。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h) —— h 为树高，递归栈深度
