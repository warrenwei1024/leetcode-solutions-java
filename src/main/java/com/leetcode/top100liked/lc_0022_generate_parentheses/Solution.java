package com.leetcode.top100liked.lc_0022_generate_parentheses;

/**
 * LeetCode 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且
 * 有效的括号组合。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current,
                           int open, int close, int max) {
        // 左右括号都用完，得到一个完整组合
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // 左括号数小于 n，可以添加左括号
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }

        // 右括号数小于左括号数，可以添加右括号
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

// 核心思路
// 回溯法 + 剪枝：用 open 和 close 分别记录已添加的左、右括号数。
// 左括号：只要数量 < n 就可以添加。
// 右括号：只有在 close < open 时才能添加，保证括号有效性。
// 当长度达到 2n 时记录结果。
//
// 时间复杂度: O(Catalan(n)) = O(4^n / (n^(3/2)))，第 n 个卡特兰数
// 空间复杂度: O(n)，递归栈深度
