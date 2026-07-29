package com.leetcode.top100liked.lc_0543_diameter_of_tree;


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
 * LeetCode 543. 二叉树的直径
 * <p>
 * 给你一棵二叉树的根节点，返回该树的直径。
 * 二叉树的直径是指树中任意两个节点之间最长路径的长度。这条路径可能经过也可能不经过根节点。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    // 全局变量，记录最大直径
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 触发 DFS 计算深度，过程中会更新 maxDiameter
        depth(root);
        return maxDiameter;
    }

    /**
     * 计算以 node 为根的子树的最大深度
     * 同时在过程中更新全局最大直径
     */
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 1. 递归计算左右子树的深度
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // 2. 【关键】更新最大直径
        // 经过当前节点 node 的最长路径 = 左子树深度 + 右子树深度
        // 注意：这里的深度是指边数，所以直接相加即可
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // 3. 返回当前节点的深度给父节点使用
        // 当前节点深度 = 左右子树中较大的那个深度 + 1 (当前节点到父节点的一条边)
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

// 核心思路
// DFS 后序遍历：递归计算左右子树深度，同时更新全局最大直径。
// 经过当前节点的路径长度 = 左深度 + 右深度，直径即所有节点该值的最大值。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h) —— 递归栈深度