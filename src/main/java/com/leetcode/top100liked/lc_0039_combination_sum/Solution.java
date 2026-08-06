package com.leetcode.top100liked.lc_0039_combination_sum;

/**
 * LeetCode 39. 组合总和
 * <p>
 * 给你一个无重复元素的整数数组 candidates 和一个目标整数 target，
 * 找出 candidates 中可以使数字和为目标数 target 的所有不同组合，并以列表形式返回。
 * candidates 中的同一个数字可以无限制重复被选取。如果至少一个数字的被选数量不同，
 * 则两种组合是不同的。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> current, List<List<Integer>> result) {
        // 找到一个合法组合
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 剩余值 < 0，剪枝
        if (remain < 0) {
            return;
        }

        // 从 start 开始选择，允许多次选择同一元素
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);                         // 选择
            backtrack(candidates, remain - candidates[i], i, current, result); // 注意传 i 而非 i+1，允许重复选
            current.remove(current.size() - 1);                  // 回溯
        }
    }
}

// 核心思路
// 回溯法 + 剪枝：从候选数组中选择数字，每次可以用当前数字或后续数字。
// 传递 i 而非 i+1 允许重复选同一数字；使用 start 参数保证非递减顺序，避免组合重复。
// 当 remain == 0 时记录结果，remain < 0 时剪枝。
//
// 时间复杂度: O(n^(T/min))，n 为候选数个数，T 为目标值
// 空间复杂度: O(T/min)，递归栈深度
