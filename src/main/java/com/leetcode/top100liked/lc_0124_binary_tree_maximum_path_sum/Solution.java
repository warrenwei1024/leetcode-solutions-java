package com.leetcode.top100liked.lc_0124_binary_tree_maximum_path_sum;

/**
 * LeetCode 124. 二叉树中的最大路径和
 * <p>
 * 二叉树中的路径被定义为一条节点序列，序列中每对相邻节点之间都有一条边相连。
 * 同一个节点在一条路径序列中至多出现一次，该路径至少包含一个节点，且不一定经过根节点。
 * 路径和是路径中各节点值的总和。给定一个二叉树的根节点 root，返回其最大路径和。
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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 计算从 node 出发向下的最大贡献值（单边路径）
     */
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子树的最大贡献，负数贡献不取
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 以当前节点为"拐点"的路径和（经过 node 的全路径）
        int currentPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPathSum);

        // 返回当前节点向上提供的最大贡献（只能选一边）
        return node.val + Math.max(leftGain, rightGain);
    }
}

// 核心思路
// 后序遍历 + 分治。对每个节点，计算其左右子树能提供的最大单边贡献。
// 以当前节点为拐点的路径和 = 自身 + 左贡献 + 右贡献，更新全局最大值。
// 向上返回时只能选择左右中的较大一侧（路径不能分叉）。
//
// 时间复杂度: O(n)
// 空间复杂度: O(h)，h 为树高，递归栈空间
