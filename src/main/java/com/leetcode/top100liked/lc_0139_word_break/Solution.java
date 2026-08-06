package com.leetcode.top100liked.lc_0139_word_break;

/**
 * LeetCode 139. 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 将字典转为 HashSet 加速查找
        Set<String> wordSet = new HashSet<>(wordDict);

        // dp[i] 表示 s[0..i) 能否被字典中的单词拼接
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;   // 空字符串视为可拼接

        // 遍历每个结束位置
        for (int i = 1; i <= s.length(); i++) {
            // 遍历所有可能的分割点 j
            for (int j = 0; j < i; j++) {
                // s[0..j) 可拼接 且 s[j..i) 在字典中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;    // 找到一种即可
                }
            }
        }

        return dp[s.length()];
    }
}

// 核心思路
// 动态规划：dp[i] 表示 s 的前 i 个字符能否被拼接。
// 转移方程：dp[i] = ∃ dp[j] && s[j..i) ∈ wordDict，其中 0 ≤ j < i。
// dp[0] = true 作为基案。双重循环检查所有可能的单词分割。
//
// 时间复杂度: O(n^2)，n 为字符串长度（substring 有额外开销）
// 空间复杂度: O(n + k)，dp 数组 + HashSet
