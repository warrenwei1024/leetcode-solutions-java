package com.leetcode.top100liked.lc_0155_min_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 155. 最小栈
 * <p>
 * 设计一个支持 push、pop、top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    class MinStack {

        // 数据栈，存储所有元素
        private Deque<Integer> dataStack;
        // 最小栈，栈顶始终是当前数据栈中的最小值
        private Deque<Integer> minStack;

        public MinStack() {
            dataStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();

        }

        public void push(int val) {
            // 1. 元素压入数据栈
            dataStack.push(val);
            // 2. 将当前值与最小栈的栈顶值比较，将较小者压入最小栈
            // 如果最小栈为空，则直接压入val
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                minStack.push(Math.min(val, minStack.peek()));
            }
        }

        public void pop() {
            // 两个栈同步弹出
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

// 核心思路
// 辅助栈：维护一个与数据栈同步的最小栈，栈顶始终为当前数据栈中的最小值。
// push 时比较当前值与最小栈栈顶，压入较小者；pop 时两栈同步弹出。
//
// 时间复杂度: O(1) —— 所有操作均为 O(1)
// 空间复杂度: O(n)
