package com.leetcode.top100liked.lc_0121_best_time_and_sell_stock;

/**
 * LeetCode 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组 prices，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}

// 核心思路
// 遍历过程中维护历史最低价格 minPrice，每天计算当日卖出可得利润，更新最大利润。
// 本质是动态规划：第 i 天卖出的最大利润 = prices[i] - min(prices[0..i-1])。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
