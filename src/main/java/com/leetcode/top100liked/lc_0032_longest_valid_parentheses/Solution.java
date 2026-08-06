package com.leetcode.top100liked.lc_0032_longest_valid_parentheses;

/**
 * LeetCode 32. 最长有效括号
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        // dp[i] 表示以 s[i] 结尾的最长有效括号长度
        int[] dp = new int[s.length()];
        int maxLen = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 情况 1：...() 形式
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 情况 2：...)) 形式，s[i-dp[i-1]-1] 与 s[i] 配对
                    dp[i] = dp[i - 1] + 2;
                    // 加上配对位置之前的最长有效长度
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }

        return maxLen;
    }
}

// 核心思路
// 动态规划：dp[i] 表示以 i 结尾的最长有效括号长度。
// 若 s[i] == ')'：
// 情况 1：s[i-1]=='('，则 dp[i] = dp[i-2] + 2
// 情况 2：s[i-1]==')'，检查 s[i-dp[i-1]-1] 是否为 '('，若是则配对成功并加上之前部分
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)
