package com.leetcode.top100liked.lc_0102_binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
 * LeetCode 102. 二叉树的层序遍历
 * <p>
 * 给你二叉树的根节点 root，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */


public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 边界情况：空树
        if (root == null) {
            return result;
        }

        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 当队列不为空时继续
        while (!queue.isEmpty()) {
            // 【关键】获取当前层的节点数量
            // 必须在 for 循环之前获取，因为 queue.size() 会在循环中变化
            int levelSize = queue.size();

            // 存储当前层的节点值
            List<Integer> currentLevel = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                // 将下一层的节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 将当前层的结果加入总结果
            result.add(currentLevel);
        }

        return result;
    }
}

// 核心思路
// BFS + 队列：使用队列进行广度优先搜索，每次处理一层。
// 关键是在每层开始时记录当前队列大小 levelSize，恰好等于该层节点数。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)