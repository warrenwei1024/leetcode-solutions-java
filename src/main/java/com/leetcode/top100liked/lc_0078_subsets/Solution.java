package com.leetcode.top100liked.lc_0078_subsets;

/**
 * LeetCode 78. 子集
 * <p>
 * 给你一个整数数组 nums，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 回溯法，从索引 0 开始探索
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // 每个状态都是一个有效子集，加入结果
        result.add(new ArrayList<>(current));

        // 从 start 开始选择，避免重复
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);                    // 选择
            backtrack(nums, i + 1, current, result); // 递归
            current.remove(current.size() - 1);       // 回溯
        }
    }
}

// 核心思路
// 回溯法：从空集开始，每次选择一个元素加入当前子集。
// 每个递归状态都产生一个有效子集。通过 start 参数控制选择起点，
// 保证不重复选择。也可以使用位掩码迭代法（2^n 种组合）。
//
// 时间复杂度: O(n * 2^n)，共 2^n 个子集，每个拷贝 O(n)
// 空间复杂度: O(n)，递归栈深度
