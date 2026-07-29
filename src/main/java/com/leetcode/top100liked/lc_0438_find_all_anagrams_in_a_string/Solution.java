package com.leetcode.top100liked.lc_0438_find_all_anagrams_in_a_string;

import java.util.*;

/**
 * LeetCode 438. 找到字符串中所有字母异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，
 * 返回这些子串的起始索引。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    /**
     * 找到字符串 s 中所有是字符串 p 的字母异位词的子串的起始索引。
     * 使用滑动窗口 + 字符频次数组（因为只包含小写字母，可用长度为26的数组优化）
     *
     * @param s 输入字符串（主串）
     * @param p 模式串（目标异位词）
     * @return 所有异位词子串的起始索引列表
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26]; // p 中每个字符的频次
        int[] windowCount = new int[26]; // 滑动窗口中每个字符的频次

        // 初始化 p 的字符频次
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();
        // 初始化第一个窗口
        for (int i = 0; i < windowSize; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }

        // 检查第一个窗口是否匹配
        if (Arrays.equals(pCount, windowCount)) {
            result.add(0);
        }

        // 滑动窗口：从第 windowSize 个字符开始向右滑动
        for (int i = windowSize; i < s.length(); i++) {
            // 加入新字符
            windowCount[s.charAt(i) - 'a']++;
            // 移除旧字符（窗口左边界）
            windowCount[s.charAt(i - windowSize) - 'a']--;

            // 检查当前窗口是否匹配
            if (Arrays.equals(pCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    // 测试方法
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // 输出: [0, 6]
        System.out.println(solution.findAnagrams("abab", "ab"));        // 输出: [0, 1, 2]
        System.out.println(solution.findAnagrams("bb", "aa"));         // 输出: [1]
        System.out.println(solution.findAnagrams("abcdefg", "xyz"));    // 输出: []
        System.out.println(solution.findAnagrams("", "a"));             // 输出: []
    }
}

// 核心思路
// 滑动窗口 + 频次数组：维护一个大小为 p.length() 的固定窗口，
// 用长度为 26 的数组记录窗口内各字符频次，与 p 的频次数组比较判断异位词。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1) —— 固定 26 大小