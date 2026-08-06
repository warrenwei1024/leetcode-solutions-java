package com.leetcode.top100liked.lc_0994_rotting_oranges;

/**
 * LeetCode 994. 腐烂的橘子
 * <p>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有三个值之一：
 * 0 代表空单元格，1 代表新鲜橘子，2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子周围 4 个方向上相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // 将所有腐烂橘子入队，同时统计新鲜橘子数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // 没有新鲜橘子，直接返回 0
        if (freshCount == 0) {
            return 0;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        // 多源 BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;      // 本轮是否有橘子被腐烂

            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // 越界或不是新鲜橘子则跳过
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n
                            || grid[newRow][newCol] != 1) {
                        continue;
                    }

                    // 腐烂新鲜橘子
                    grid[newRow][newCol] = 2;
                    freshCount--;
                    queue.offer(new int[]{newRow, newCol});
                    rotted = true;
                }
            }

            if (rotted) {
                minutes++;
            }
        }

        // 仍有新鲜橘子说明无法全部腐烂
        return freshCount == 0 ? minutes : -1;
    }
}

// 核心思路
// 多源 BFS：将所有初始腐烂橘子同时入队，每分钟向外扩散一层。
// 统计新鲜橘子数量，每腐烂一个就减一。BFS 结束后若仍有新鲜橘子则返回 -1。
//
// 时间复杂度: O(m * n)
// 空间复杂度: O(m * n)，队列最大长度
