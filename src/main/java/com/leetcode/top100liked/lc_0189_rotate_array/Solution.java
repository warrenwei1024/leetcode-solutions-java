package com.leetcode.top100liked.lc_0189_rotate_array;

public class Solution {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length <=1) {
            return;
        }

        int n = nums.length;
        // 1. 处理 k 大于数组长度的情况
        k = k % n;

        // 2. 翻转整个数组
        reverse(nums, 0, n - 1);

        // 3. 翻转前 k 个元素
        reverse(nums, 0, k - 1);

        // 4. 翻转剩下的元素
        reverse(nums, k, n - 1);

    }


    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
