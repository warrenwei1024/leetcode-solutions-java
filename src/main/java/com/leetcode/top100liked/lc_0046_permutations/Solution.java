package com.leetcode.top100liked.lc_0046_permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums，返回其所有可能的全排列。
 * 你可以按任意顺序返回答案。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 记录当前路径
        List<Integer> track = new ArrayList<>();

        // 记录数字是否被使用过
        boolean[] used = new boolean[nums.length];

        backtrack(nums,res,track,used);
        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res,List<Integer> track, boolean[] used) {
        // 触发结束条件：当前路径的长度等于数组长度，说明找到了一个全排列
        if (track.size() == nums.length) {
            // 注意：必须 new 一个新的 ArrayList，否则存进去的是引用，后续修改会影响结果
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果该数字已经被使用过，跳过
            if(used[i]) continue;

            // 做选择
            track.add(nums[i]);
            used[i] = true;

            // 进入下一层决策树
            backtrack(nums, res, track, used);

            // 撤销选择（回溯）
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }
}

// 核心思路
// 回溯算法：通过递归遍历决策树，used 数组记录已选元素避免重复。
// 到达叶子节点（路径长度 == 数组长度）时将当前路径加入结果集。
//
// 时间复杂度: O(n * n!)
// 空间复杂度: O(n) —— 递归栈深度
