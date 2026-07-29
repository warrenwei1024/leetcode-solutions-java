package com.leetcode.top100liked.lc_0075_sort_colors;

/**
 * LeetCode 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 使用整数 0、1 和 2 分别表示红色、白色和蓝色。必须不使用库函数排序。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;                   // 指向下一个存放 0 的位置
        int right = nums.length - 1;    // 指向下一个存放 2 的位置
        int curr = 0;                   // 当前遍历的指针

        while (curr <= right) {
            // 发现 0，换到左边
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                left++;
                curr++;
            }else if (nums[curr] == 2) {
                // 发现 2，换到右边
                swap(nums, curr, right);
                right--;
                // 注意：这里 curr 不需要 ++，因为换过来的新数还需要在下一轮继续判断
            }else{
                // 发现 1，保持不动，继续往前走
                curr++;
            }
        }
    }

    // 辅助交互函数
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 核心思路
// 荷兰国旗问题：三指针，left 指向下一个 0 的位置，right 指向下一个 2 的位置，
// curr 遍历数组。遇到 0 换到左边，遇到 2 换到右边，遇到 1 跳过。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
