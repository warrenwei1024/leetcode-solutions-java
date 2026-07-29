package com.leetcode.top100liked.lc_0049_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode 49. 字母异位词分组
 * <p>
 * 给你一个字符串数组，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs){
        // 创建 HashMap，key 为排序后的字符串，value 为该类异位词列表
        HashMap<String, List<String>> map = new HashMap<>();

        // 遍历每个字符串
        for(String s: strs){
            // 将字符串转为字符数组
            char[] chars = s.toCharArray();

            // 对字符数组排序
            Arrays.sort(chars);

            // 将排序后的字符数组重新转为字符串，作为 HashMap 的 key
            String key = new String(chars);

//            if (!map.containsKey(key)) {   // 判断 key 是否存在
//                map.put(key, new ArrayList<>());  // 如果不存在，则初始化一个空列表
//            }

            // 如果 key 不存在，则初始化一个空列表
            map.putIfAbsent(key, new ArrayList<>());

            // 将原字符串加入对应的列表中
            map.get(key).add(s);
        }

        // 将 HashMap 中的所有值（列表）组成结果返回
        return new ArrayList<>(map.values());
    }
}

// 核心思路
// 哈希表分组：将每个字符串按字母排序后作为 key，同一 key 的字符串即为
// 字母异位词。使用 putIfAbsent 简化 key 不存在时的初始化逻辑。
//
// 时间复杂度: O(n * k log k)
// 空间复杂度: O(n * k)

