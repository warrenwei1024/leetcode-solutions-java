package com.leetcode.top100liked.lc_0005_longest_palindromic_substring;

/**
 * LeetCode 5. 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;    // 最长回文子串起始位置
        int maxLen = 1;   // 最长回文子串长度

        // 中心扩展法：对每个位置作为中心向外扩展
        for (int i = 0; i < s.length(); i++) {
            // 奇数长度回文（以单个字符为中心）
            int len1 = expandAroundCenter(s, i, i);
            // 偶数长度回文（以两个字符之间为中心）
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                // 根据中心位置和长度反推起始位置
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * 从中心向两边扩展，返回回文长度
     */
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 返回有效回文长度：right - left - 1
        return right - left - 1;
    }
}

// 核心思路
// 中心扩展法：遍历每个可能的回文中心（共 2n-1 个），向两边扩展。
// 每个位置考虑两种中心：奇数长度（单个字符）和偶数长度（两个字符间）。
// 记录最长回文的起始位置和长度，最后用 substring 截取。
//
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)
