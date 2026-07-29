package com.leetcode.top100liked.lc_0108_convert_sorted_array_to_binary_search_tree;

// Definition for a binary tree node.
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
 * LeetCode 108. 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按升序排列，请你将其转换为一棵
 * 高度平衡二叉搜索树。高度平衡二叉树是一棵满足「每个节点的左右两个
 * 子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-08
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        // 边界处理
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 递归构建高度平衡的 BST
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * 在 [left, right] 闭区间内递归构建 BST
     */
    private TreeNode buildBST(int[] nums, int left, int right) {
        // 递归终止条件：区间无效
        if (left > right) {
            return null;
        }

        // 总是选择中间位置作为根节点，保证高度平衡
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左右子树
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}

// 核心思路
// 由于数组已升序排列，每次选取区间中点作为根节点，
// 左半区间递归构建左子树，右半区间递归构建右子树，
// 即可天然保证 BST 性质且高度平衡。
//
// 时间复杂度: O(n) —— 每个元素访问一次
// 空间复杂度: O(log n) —— 递归栈深度为树高
