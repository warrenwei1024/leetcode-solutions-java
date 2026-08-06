package com.leetcode.top100liked.lc_0238_product_of_array_except_self;

/**
 * LeetCode 238. 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组 nums，返回数组 answer，其中 answer[i] 等于 nums 中除 nums[i]
 * 之外其余各元素的乘积。要求：时间复杂度 O(n)，不能使用除法。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public int[] productExceptSelf(int[] nums) {
        // 边界处理
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] answer = new int[n];

        // 第一趟：计算每个位置左侧所有元素的乘积
        answer[0] = 1;                      // 最左侧没有元素，乘积为 1
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 第二趟：从右向左，乘上右侧所有元素的乘积
        int rightProduct = 1;               // 最右侧没有元素，乘积为 1
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];  // 更新右侧累积乘积
        }

        return answer;
    }
}

// 核心思路
// 两次遍历：第一遍从左到右，answer[i] 存 i 左侧所有元素的乘积；
// 第二遍从右到左，用一个变量累积右侧乘积，乘入 answer[i] 即可。
// 这样每个位置恰好排除了自身，且无需额外数组，O(1) 额外空间。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)（不计输出数组）
