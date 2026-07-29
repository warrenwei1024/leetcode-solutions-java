package com.leetcode.top100liked.lc_0128_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 128. 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums，找出数字连续的最长序列的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    /**
     * 找到数组中最长连续序列的长度
     * 使用HashSet实现O(n)时间复杂度的解法
     *
     * @param nums 整数数组
     * @return 最长连续序列的长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 将所有数字存入HashSet，便于O(1)时间查找
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // 遍历每个数字，只从连续序列的起始点开始计算
        for (int num : numSet) {
            // 只有当num-1不存在时，num才是连续序列的起始点
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 向后查找连续的数字
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // 更新最大长度
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    // 测试方法
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1: [100,4,200,1,3,2] -> 4 (序列1,2,3,4)
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("输入: [100,4,200,1,3,2]");
        System.out.println("输出: " + solution.longestConsecutive(nums1));

        // 测试用例2: [0,3,7,2,5,8,4,6,0,1] -> 9 (序列0到8)
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("输入: [0,3,7,2,5,8,4,6,0,1]");
        System.out.println("输出: " + solution.longestConsecutive(nums2));

        // 测试用例3: 空数组 -> 0
        int[] nums3 = {};
        System.out.println("输入: []");
        System.out.println("输出: " + solution.longestConsecutive(nums3));

        // 测试用例4: 单个元素 -> 1
        int[] nums4 = {5};
        System.out.println("输入: [5]");
        System.out.println("输出: " + solution.longestConsecutive(nums4));
    }
}

// 核心思路
// 将所有数字存入 HashSet，然后遍历集合。仅当 num-1 不存在时（即 num 是
// 连续序列的起点），才向后查找 num+1, num+2, ... 计算长度。
//
// 时间复杂度: O(n)
// 空间复杂度: O(n)



