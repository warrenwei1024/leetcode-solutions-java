package com.leetcode.top100liked.lc_0056_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 56. 合并区间
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {

    public int[][] merge(int[][] intervals) {

        // 边界条件处理
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 1. 核心步骤：按照区间的左端点（起始位置）进行升序
        // 使用 Lambda 表达式：Integer.compare 防止减法溢出
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 用一个动态列表来存放综合合并后的区间
        List<int[]> merged = new ArrayList<>();

        // 2. 遍历所有区间
        for (int[] interval : intervals) {
            // 如果列表为空，或者当前区间的左端点大于结果集中最后一个区间的右端点，说明不重叠
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // 否则说明有重叠，合并区间：更新结果集中最后一个区间的右端点为两者的最大值
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // 3. 将 List 转换为题目要求的二维数组返回
        return merged.toArray(new int[merged.size()][]);
    }
}

// 核心思路
// 先按区间左端点排序，然后遍历合并：若当前区间与结果集最后一个区间重叠
// （左端点 <= 右端点），则更新右端点为两者最大值；否则直接加入。
//
// 时间复杂度: O(n log n)
// 空间复杂度: O(n)
