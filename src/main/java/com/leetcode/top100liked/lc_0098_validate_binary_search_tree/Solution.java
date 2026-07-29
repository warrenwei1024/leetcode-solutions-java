package com.leetcode.top100liked.lc_0098_validate_binary_search_tree;


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
 * LeetCode 98. 验证二叉搜索树
 * <p>
 * 给你一个二叉树的根节点 root，判断其是否是一个有效的二叉搜索树。
 * 有效二叉搜索树定义：节点的左子树只包含小于当前节点的数，
 * 节点的右子树只包含大于当前节点的数，且所有左子树和右子树自身也是二叉搜索树。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */


public class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // 空节点视为有效
        if (node == null) {
            return true;
        }

        // 检查当前节点值是否在合法范围内 (开区间)
        if(node.val <= min || node.val >= max) {
            return false;
        }

        // 递归检查左右子树
        // 左子树的上界变为当前节点值
        // 右子树的下界变为当前节点值
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);

    }
}

// 核心思路
// 递归 + 上下界：为每个节点维护一个合法值区间 (min, max)，
// 初始为 (-inf, +inf)。向左递归时更新上界，向右递归时更新下界。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h) —— 递归栈深度
