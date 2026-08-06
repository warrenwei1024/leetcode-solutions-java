package com.leetcode.top100liked.lc_0169_majority_element;

/**
 * LeetCode 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组 nums，返回其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊n/2⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int majorityElement(int[] nums) {
        // Boyer-Moore 投票算法
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                // 更换候选元素
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // 题目保证一定存在多数元素，candidate 即为结果
        return candidate;
    }
}

// 核心思路
// Boyer-Moore 投票算法：多数元素出现次数 > n/2，意味着它的票数抵消所有非多数元素后仍有剩余。
// 遍历数组，遇到相同元素 count++，不同则 count--。count 归零时更换候选。
// 由于多数元素数量占据优势，最终剩余的一定是它。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
