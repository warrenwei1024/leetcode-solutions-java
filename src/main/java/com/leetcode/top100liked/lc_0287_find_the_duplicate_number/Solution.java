package com.leetcode.top100liked.lc_0287_find_the_duplicate_number;

/**
 * LeetCode 287. 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 [1, n] 范围内（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设 nums 只有一个重复的整数，
 * 返回这个重复的数。要求不修改数组且只用常量级 O(1) 额外空间。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int findDuplicate(int[] nums) {
        // Floyd 判圈算法（快慢指针），将数组视为链表
        int slow = nums[0];
        int fast = nums[0];

        // 第一阶段：快慢指针相遇，找到环内相遇点
        do {
            slow = nums[slow];          // 走一步
            fast = nums[nums[fast]];    // 走两步
        } while (slow != fast);

        // 第二阶段：找到环的入口（即重复元素）
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

// 核心思路
// Floyd 判圈算法（链表找环入口）：将 nums[i] 视为指向 nums[nums[i]] 的指针。
// 由于有重复元素，数组形成带环的隐式链表，重复元素即为环的入口。
// 第一阶段快慢指针在环内相遇；第二阶段一个从起点、一个从相遇点同步走，相遇处即入口。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
