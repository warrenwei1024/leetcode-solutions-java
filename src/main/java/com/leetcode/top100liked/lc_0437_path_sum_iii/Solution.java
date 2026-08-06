package com.leetcode.top100liked.lc_0437_path_sum_iii;

/**
 * LeetCode 437. 路径总和 III
 * <p>
 * 给定一个二叉树的根节点 root 和一个整数 targetSum，求该二叉树里节点值之和
 * 等于 targetSum 的路径数目。路径不需要从根节点开始，也不需要在叶子节点结束，
 * 但是路径方向必须是向下的（只能从父节点到子节点）。
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

    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和映射：prefixSum → 出现次数
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        // 前缀和为 0 的路径初始有一条（空路径）
        prefixSumMap.put(0L, 1);

        dfs(root, 0L, targetSum, prefixSumMap);
        return count;
    }

    private void dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null) {
            return;
        }

        // 更新当前路径的前缀和
        currentSum += node.val;

        // 查找是否存在前缀和为 currentSum - targetSum 的路径
        // 若存在，则从该路径末尾到当前节点构成一条合法路径
        count += prefixSumMap.getOrDefault(currentSum - targetSum, 0);

        // 将当前前缀和加入映射
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // 递归左右子树
        dfs(node.left, currentSum, targetSum, prefixSumMap);
        dfs(node.right, currentSum, targetSum, prefixSumMap);

        // 回溯：离开当前节点时移除当前前缀和
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);
    }
}

// 核心思路
// 使用前缀和 + HashMap，将树的问题转化为类数组的"和为 K 的子数组"问题。
// 在 DFS 过程中维护从根到当前节点的前缀和，查找 prefixSum - targetSum 的出现次数。
// 注意回溯时需移除当前前缀和计数，避免不同分支间的干扰。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)，HashMap + 递归栈
