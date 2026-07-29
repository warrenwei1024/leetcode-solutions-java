package com.leetcode.top100liked.lc_0003_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    /**
     * 找到字符串中无重复字符的最长子串的长度
     * 使用滑动窗口算法，维护一个窗口[left, right]，窗口内无重复字符
     *
     * @param s 输入字符串
     * @return 无重复字符的最长子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // 用于存储字符及其最新出现的位置
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0;  // 滑动窗口左边界
        int maxLength = 0;  // 记录最长子串长度

        // 遍历字符串，right为滑动窗口右边界
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果当前字符已经在窗口中出现过
            if (charIndexMap.containsKey(currentChar)) {
                // 更新左边界，确保窗口内无重复字符
                // 注意：left不能向左移动，只能向右或保持不变
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            // 更新当前字符的最新位置
            charIndexMap.put(currentChar, right);

            // 更新最长子串长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // 测试方法
    public static void main(String[] args) {
        Solution solution = new Solution();


        // 测试用例
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 输出: 3 ("abc")
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // 输出: 1 ("b")
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // 输出: 3 ("wke")
        System.out.println(solution.lengthOfLongestSubstring(""));         // 输出: 0
        System.out.println(solution.lengthOfLongestSubstring("abcdef"));   // 输出: 6 ("abcdef")
        System.out.println(solution.lengthOfLongestSubstring("aab"));      // 输出: 2 ("ab")
    }
}

// 核心思路
// 滑动窗口：右指针不断右移扩展窗口，若遇到重复字符则左指针跳到重复字符
// 的下一个位置。用哈希表记录每个字符最新出现的位置，实时更新最大窗口长度。
//
// 时间复杂度: O(n)
// 空间复杂度: O(min(n, 128)) —— 字符集大小
