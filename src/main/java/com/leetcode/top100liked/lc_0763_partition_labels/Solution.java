package com.leetcode.top100liked.lc_0763_partition_labels;

/**
 * LeetCode 763. 划分字母区间
 * <p>
 * 给你一个字符串 s。我们要把这个字符串划分为尽可能多的片段，
 * 同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        // 记录每个字符在字符串中最后一次出现的索引
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0;      // 当前片段的起始位置
        int end = 0;        // 当前片段必须到达的最远位置

        for (int i = 0; i < s.length(); i++) {
            // 更新当前片段的最远边界
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            // 当前位置恰好到达当前片段的最远边界，划分一个片段
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;    // 下一个片段起始位置
            }
        }

        return result;
    }
}

// 核心思路
// 贪心 + 哈希表：先遍历一遍记录每个字符最后一次出现的位置。
// 再遍历时维护当前片段的结束边界 end = max(end, lastIndex[c])。
// 当 i == end 时，说明当前片段内所有字符都不会在后面出现了，可以分割。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)，26 个字母的数组
