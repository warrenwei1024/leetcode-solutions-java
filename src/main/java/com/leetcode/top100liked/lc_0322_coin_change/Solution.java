package com.leetcode.top100liked.lc_0322_coin_change;

/**
 * LeetCode 322. 零钱兑换
 * <p>
 * 给你一个整数数组 coins，表示不同面额的硬币；以及一个整数 amount，表示总金额。
 * 计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，
 * 返回 -1。你可以认为每种硬币的数量是无限的。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // dp[i] 表示凑成金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        // 初始化为 amount+1（相当于无穷大）
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // 完全背包：遍历每个金额
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // 使用一枚 coin，剩余金额 i-coin 的最优解 + 1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // dp[amount] 仍为初始值说明无法凑成
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

// 核心思路
// 动态规划（完全背包）：dp[i] = min(dp[i - coin] + 1)，对所有 coin ≤ i。
// 金额从小到大递推，每种硬币可无限使用。初始化 dp[0]=0，其余为无穷大。
// dp[amount] 超过 amount 说明无解，返回 -1。
//
// 时间复杂度: O(amount * k)，k 为硬币种类数
// 空间复杂度: O(amount)
