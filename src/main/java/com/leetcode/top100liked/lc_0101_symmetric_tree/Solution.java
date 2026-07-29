package com.leetcode.top100liked.lc_0101_symmetric_tree;

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
 * LeetCode 101. 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root，检查它是否轴对称。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 检查左右子树是否互为镜像
        return check(root.left, root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        // 1. 两个节点都为空，对称
        if (p == null && q == null) {
            return true;
        }
        // 2. 只有一个为空，或者值不相等，不对称
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // 3. 递归检查：
        // p的左子树 vs q的右子树
        // p的右子树 vs q的左子树
        return check(p.left, q.right) && check(p.right, q.left);
    }
}

// 核心思路
// 递归比较两棵子树是否互为镜像：两个根节点值相等，且 p.left 与 q.right
// 互为镜像、p.right 与 q.left 互为镜像。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h) —— 递归栈深度
