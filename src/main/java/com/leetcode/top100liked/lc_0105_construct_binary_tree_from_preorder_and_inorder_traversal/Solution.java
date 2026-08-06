package com.leetcode.top100liked.lc_0105_construct_binary_tree_from_preorder_and_inorder_traversal;

/**
 * LeetCode 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder，其中 preorder 是二叉树的前序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 假设不含重复元素。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.HashMap;
import java.util.Map;

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

    private Map<Integer, Integer> inorderIndexMap;
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建 inorder 值 → 索引的映射，O(1) 定位根节点在 inorder 中的位置
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // 前序遍历的第一个元素即为当前子树的根
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根的位置，划分左右子树
        int inorderIndex = inorderIndexMap.get(rootVal);
        root.left = build(preorder, left, inorderIndex - 1);
        root.right = build(preorder, inorderIndex + 1, right);

        return root;
    }
}

// 核心思路
// 前序：根 → 左 → 右，中序：左 → 根 → 右。
// 前序首元素是根，在 inorder 中找到该根，左边是左子树，右边是右子树。
// 递归构建，用 HashMap 加速查找 inorder 中的根位置。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)，HashMap + 递归栈
