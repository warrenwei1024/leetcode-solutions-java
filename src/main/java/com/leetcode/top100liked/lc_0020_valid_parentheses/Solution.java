package com.leetcode.top100liked.lc_0020_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s，判断字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合，左括号必须以正确的顺序闭合。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public boolean isValid(String s) {
        // 特殊情况：如果长度为奇数，肯定无法完全匹配
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 遇到左括号，压入对应的右括号
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // 遇到右括号，检查栈顶是否匹配
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // 栈为空说明所有括号都匹配完毕
        return stack.isEmpty();
    }
}

// 核心思路
// 使用栈匹配括号：遇到左括号压入对应的右括号，遇到右括号则弹出栈顶比较。
// 若栈为空或不匹配则无效；最终栈为空才说明完全匹配。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)
