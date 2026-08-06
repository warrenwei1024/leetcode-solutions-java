package com.leetcode.top100liked.lc_0236_lowest_common_ancestor_of_a_binary_tree;

/**
 * LeetCode 236. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树，找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先定义为：两个节点 p 和 q 的最近公共祖先是同时包含这两个节点的
 * 最低节点（一个节点也可以是它自己的祖先）。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止：找到 p/q 或到达空节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 分别在左右子树中查找 p 和 q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右子树各找到一个节点，说明当前 root 就是 LCA
        if (left != null && right != null) {
            return root;
        }

        // 否则返回非空的那个结果（p 和 q 在同一子树中，或都不存在）
        return left != null ? left : right;
    }
}

// 核心思路
// 后序遍历，自底向上查找。递归返回值含义：子树中是否含有 p 或 q。
// 如果 left 和 right 同时非空，说明 p 和 q 分别在左右子树，root 即为 LCA。
// 如果只有一个非空，说明 p 和 q 都在该子树中，直接返回该结果。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h)，h 为树高，递归栈空间
