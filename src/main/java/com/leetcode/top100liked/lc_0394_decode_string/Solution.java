package com.leetcode.top100liked.lc_0394_decode_string;

/**
 * LeetCode 394. 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为 k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 你可以认为输入字符串总是有效的，没有额外的空格，且方括号总是匹配的。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.Stack;

public class Solution {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();  // 存放重复次数
        Stack<StringBuilder> strStack = new Stack<>(); // 存放之前的字符串
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 累积数字（可能多位）
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // 入栈：保存当前状态，开始处理括号内内容
                countStack.push(k);
                strStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                // 出栈：将括号内字符串重复 k 次，拼接到之前的字符串上
                int repeat = countStack.pop();
                StringBuilder decoded = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                // 普通字母，直接追加
                current.append(c);
            }
        }

        return current.toString();
    }
}

// 核心思路
// 用两个栈分别存储重复次数和之前的字符串状态。
// 遇到 '[' 时将当前状态压栈并重置；遇到 ']' 时弹出，重复括号内内容并拼接。
// 数字需注意可能有多位，用 k = k*10 + digit 累积。
//
// 时间复杂度: O(n)，n 为解码后字符串长度
// 空间复杂度: O(n)，栈深度
