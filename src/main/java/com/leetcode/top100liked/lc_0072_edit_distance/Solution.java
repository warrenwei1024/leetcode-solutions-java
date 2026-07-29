package com.leetcode.top100liked.lc_0072_edit_distance;

/**
 * LeetCode 72. 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2，请返回将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行插入一个字符、删除一个字符、替换一个字符三种操作。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] 表示 word1 前 i 个字符变成 word2 前 j 个字符的最少步数
        int[][] dp = new int[m + 1][n + 1];

        // 1. 初始化边界条件
        // dp[i][0] 表示 word2 是 null,word1 前 i 个字符通过删除才能成为 word2,即null
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // dp[0][j] 表示 word1 是 null,word1 只能通过插入对应 j 个字符才能成为 word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 2. 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 字符相同，不消耗操作步数
                    dp[i][j] = dp[i - 1][j - 1];
                }else{

                    // 字符不同，从三种操作（删、增、替）中选步骤最少的，再加上当前这一步
                    int delete = dp[i - 1][j];
                    int insert = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = Math.min(Math.min(delete, insert), replace) + 1;
                }
            }
        }

        // 最终答案即为整个字符串转换的最小距离
        return dp[m][n];
    }
}

// 核心思路
// 动态规划：dp[i][j] 表示 word1[0..i) 转换为 word2[0..j) 的最少操作数。
// 字符相同时继承 dp[i-1][j-1]；不同时取删除、插入、替换三者最小值 + 1。
//
// 时间复杂度: O(m * n)
// 空间复杂度: O(m * n)
