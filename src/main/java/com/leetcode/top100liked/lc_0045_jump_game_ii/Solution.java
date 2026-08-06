package com.leetcode.top100liked.lc_0045_jump_game_ii;

/**
 * LeetCode 45. 跳跃游戏 II
 * <p>
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。
 * 返回到达 nums[n-1] 的最小跳跃次数。题目保证可以到达。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int jumps = 0;              // 跳跃次数
        int currentEnd = 0;         // 当前跳跃可达的最远位置
        int farthest = 0;           // 下一步可达的最远位置

        // 遍历到 n-2 即可，因为到达最后一个位置不需要再跳
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新从当前位置出发能到达的最远距离
            farthest = Math.max(farthest, i + nums[i]);

            // 到达当前跳跃的边界时，必须再跳一步
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // 提前终止：如果已经可以到达终点
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}

// 核心思路
// 贪心法：每次在可达范围内选择能跳到最远位置的那一步。
// 用 currentEnd 标记当前跳跃能到达的边界，farthest 记录下一步能到的最远位置。
// 当 i 到达 currentEnd 时，必须增加一次跳跃，并将边界更新为 farthest。
//
// 时间复杂度: O(n)
// 空间复杂度: O(1)
