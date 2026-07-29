package com.leetcode.top100liked.lc_0136_single_number;

/**
 * LeetCode 136. 只出现一次的数字
 * <p>
 * 给你一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。你必须实现线性时间复杂度且只使用常量额外空间。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int single = 0;
        // 把数组中的所有元素全部异或一遍
        // a ^ a = 0, a ^ 0 = a，成对出现的数字异或后抵消，只剩落单的那个
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

// 核心思路
// 异或运算的性质：a ^ a = 0，a ^ 0 = a，且满足交换律和结合律。
// 将所有数字异或，成对出现的数字互相抵消，最终结果即为只出现一次的数字。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
