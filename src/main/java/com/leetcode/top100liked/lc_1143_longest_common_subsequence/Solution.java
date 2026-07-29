package com.leetcode.top100liked.lc_1143_longest_common_subsequence;

/**
 * LeetCode 1143. 最长公共子序列
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 如果不存在公共子序列，返回 0。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // dp[i][j] 代表 text1 前 i 个字符与 text2 前 j 个字符的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        // 嵌套遍历两个字符串
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 注意：dp 数组索引从 1 开始，对应的字符串字符索引要减 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 如果字符相等，找到一个公共字符，长度在左上方子问题基础上 +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等，取「上方」或「左方」的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 右下角的值即为最终结果
        return dp[m][n];
    }
}

// 核心思路
// 动态规划：dp[i][j] 表示 text1[0..i) 与 text2[0..j) 的最长公共子序列长度。
// 字符相等时 dp[i][j] = dp[i-1][j-1] + 1；不相等时取 max(dp[i-1][j], dp[i][j-1])。
//
// 时间复杂度: O(m * n)
// 空间复杂度: O(m * n)