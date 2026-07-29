package com.leetcode.top100liked.lc_0015_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15. 三数之和
 * <p>
 * 给你一个整数数组 nums，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k，同时还满足 nums[i] + nums[j] + nums[k] == 0。
 * 请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    /**
     * 找出数组中所有和为 0 的不重复三元组。
     * 使用排序 + 双指针方法。
     * @param nums 给定的整数数组
     * @return 所有不重复的三元组列表
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // 边界检查
        if (nums == null || nums.length < 3) {
            return result;
        }

        // 1. 排序
        Arrays.sort(nums);

        // 2. 遍历数组，固定第一个数 nums[i]
        for (int i = 0; i < nums.length - 2; i++) {
            // 剪枝：如果当前数大于0，后面的数都大于0，三数之和不可能为0
            if (nums[i] > 0) {
                break;
            }

            // 去重：跳过重复的 nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3. 双指针在 i 之后的子数组中寻找两数之和等于 -nums[i]
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到一个解
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 去重：跳过所有重复的 left 和 right
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 移动指针到下一对不同的数
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和太小，需要增大，移动左指针
                    left++;
                } else {
                    // 和太大，需要减小，移动右指针
                    right--;
                }
            }
        }

        return result;
    }

    // --- 测试代码 ---
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("输入: " + Arrays.toString(nums1));
        System.out.println("输出: " + solution.threeSum(nums1));
        // 期望输出: [[-1, -1, 2], [-1, 0, 1]]
        System.out.println();

        // 测试用例2
        int[] nums2 = {0, 1, 1};
        System.out.println("输入: " + Arrays.toString(nums2));
        System.out.println("输出: " + solution.threeSum(nums2));
        // 期望输出: []
        System.out.println();

        // 测试用例3
        int[] nums3 = {0, 0, 0};
        System.out.println("输入: " + Arrays.toString(nums3));
        System.out.println("输出: " + solution.threeSum(nums3));
        // 期望输出: [[0, 0, 0]]
        System.out.println();

        // 测试用例4
        int[] nums4 = {-2, 0, 1, 1, 2};
        System.out.println("输入: " + Arrays.toString(nums4));
        System.out.println("输出: " + solution.threeSum(nums4));
        // 期望输出: [[-2, 0, 2], [-2, 1, 1]]
    }
}

// 核心思路
// 排序 + 双指针：先排序，固定第一个数 nums[i]，然后在剩余子数组中用
// 双指针找两数之和等于 -nums[i]。注意跳过重复元素避免结果重复。
//
// 时间复杂度: O(n^2)
// 空间复杂度: O(1) —— 不计结果列表
