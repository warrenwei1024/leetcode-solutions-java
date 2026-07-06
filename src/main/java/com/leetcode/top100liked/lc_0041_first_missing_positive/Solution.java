package com.leetcode.top100liked.lc_0041_first_missing_positive;

public class Solution {
    public int firstMissingPositive(int[] nums){

        int n = nums.length;

        // 1. 第一遍遍历：尝试让每个满足条件的数字“回到它自己的家”
        for(int i = 0; i<n; i++){
            // 只有当 nums[i] 在 [1, n] 范围内，且它不在它该在的位置上时，才进行交换
            // 注意：nums[i] 应该去的索引是 nums[i] - 1
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                // 交换 nums[i] 和 nums[nums[i] - 1]
                swap(nums, i, nums[i] - 1);
            }
        }

        // 2. 第二遍遍历：寻找第一个没有各就各位的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // 发现不匹配，i + 1 就是缺失的第一个正数
            }
        }

        // 3. 如果所有数字都各就各位了（例如数组是 [1, 2, 3]），那么答案就是 n + 1
        return n + 1;

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
