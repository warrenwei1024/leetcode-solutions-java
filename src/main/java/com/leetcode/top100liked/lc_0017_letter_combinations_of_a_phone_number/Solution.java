package com.leetcode.top100liked.lc_0017_letter_combinations_of_a_phone_number;

/**
 * LeetCode 17. 电话号码的字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 数字到字母的映射与电话按键相同（2→abc, 3→def, ... 9→wxyz）。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 数字到字母的映射表
    private static final String[] MAPPING = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // 处理完所有数字，保存结果
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 获取当前数字对应的字母集
        String letters = MAPPING[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);                             // 选择
            backtrack(digits, index + 1, current, result); // 递归下一个数字
            current.deleteCharAt(current.length() - 1);     // 回溯
        }
    }
}

// 核心思路
// 回溯法：每个数字对应一组字母，按顺序为每个数字选择一个字母。
// 递归深度为数字个数，每次选择一个字母后进入下一层。
// 到达末尾时保存当前组合，然后回溯尝试其他字母。
//
// 时间复杂度: O(3^m * 4^n)，m 为 3 字母数字数，n 为 4 字母数字数
// 空间复杂度: O(k)，k 为数字个数，递归栈深度
