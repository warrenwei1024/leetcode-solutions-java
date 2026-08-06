package com.leetcode.top100liked.lc_0118_pascals_triangle;

/**
 * LeetCode 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // 每行的第一个元素始终为 1
            row.add(1);

            // 计算中间元素：上一行相邻两数之和
            for (int j = 1; j < i; j++) {
                List<Integer> prevRow = result.get(i - 1);
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // 每行的最后一个元素始终为 1（第一行仅有 1 个元素，即首尾重合）
            if (i > 0) {
                row.add(1);
            }

            result.add(row);
        }

        return result;
    }
}

// 核心思路
// 动态规划逐行生成。每行首尾为 1，中间元素 = 上一行同列 + 上一行前一列。
// 第 i 行有 i+1 个元素，通过对上一行的引用直接计算。
//
// 时间复杂度: O(numRows^2)
// 空间复杂度: O(1)，不计输出
