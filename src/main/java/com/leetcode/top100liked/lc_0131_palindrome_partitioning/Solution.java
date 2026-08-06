package com.leetcode.top100liked.lc_0131_palindrome_partitioning;

/**
 * LeetCode 131. 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // 预计算所有子串是否为回文：dp[i][j] 表示 s[i..j] 是否为回文
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        backtrack(s, 0, new ArrayList<>(), result, isPalindrome);
        return result;
    }

    private void backtrack(String s, int start, List<String> current,
                           List<List<String>> result, boolean[][] isPalindrome) {
        // 分割完成
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 尝试所有可能的分割位置
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) {
                // 当前子串是回文，加入并递归处理剩余部分
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, current, result, isPalindrome);
                current.remove(current.size() - 1);  // 回溯
            }
        }
    }
}

// 核心思路
// 回溯 + DP 预计算。先用 DP 计算出所有子串是否为回文（O(n^2)），
// 然后回溯枚举所有分割方案。每次从 start 出发，若 s[start..end] 是回文，
// 则将其加入当前路径并递归处理剩余部分。
//
// 时间复杂度: O(n * 2^n)，共有 2^(n-1) 种分割方式
// 空间复杂度: O(n^2)，DP 表 + 递归栈
