package com.leetcode.top100liked.lc_0739_daily_temperatures;

/**
 * LeetCode 739. 每日温度
 * <p>
 * 给定一个整数数组 temperatures，表示每天的温度，返回一个数组 answer，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // 单调递减栈，存储索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 当前温度高于栈顶索引对应的温度时，弹出并计算间距
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        // 栈中剩余索引对应的 answer 默认为 0（没有更高温度）
        return answer;
    }
}

// 核心思路
// 单调递减栈：栈中存储尚未找到更高温度的索引，温度值单调递减。
// 遍历时若当前温度 > 栈顶温度，说明栈顶索引找到了下一个更高温度，
// 弹出并计算距离。最终栈中剩余的表示没有更高温度，默认为 0。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)，栈空间
