package com.leetcode.top100liked.lc_0055_jump_game;

/**
 * LeetCode 55. 跳跃游戏
 * <p>
 * 给你一个非负整数数组 nums，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) return true; // 边界情况，虽然题目通常保证非空

        int maxReach = 0; // 当前能到达的最远下标

        for (int i = 0; i < n; i++) {
            // 如果当前下标超过了能到达的最远距离，说明无法继续前进
            if (i > maxReach) {
                return false;
            }

            // 更新最远能到达的距离
            // 当前位置 i 加上能跳的步数 nums[i]
            maxReach = Math.max(maxReach, i + nums[i]);

            // 优化：如果最远距离已经能覆盖终点，提前返回
            if (maxReach >= n - 1) {
                return true;
            }
        }

        return true;
    }
}

// 核心思路
// 贪心算法：遍历数组并维护当前能到达的最远位置 maxReach。
// 若当前位置 i > maxReach，说明无法到达；若 maxReach >= n-1，提前返回 true。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
