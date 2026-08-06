package com.leetcode.top100liked.lc_0051_n_queens;

/**
 * LeetCode 51. N 皇后
 * <p>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // 棋盘，'.' 表示空，'Q' 表示皇后
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result) {
        int n = board.length;

        // 所有行都已放置皇后，保存结果
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        // 尝试在当前行的每一列放置皇后
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';                    // 放置
                backtrack(board, row + 1, result);         // 递归下一行
                board[row][col] = '.';                     // 回溯
            }
        }
    }

    /**
     * 检查在 (row, col) 放置皇后是否合法（仅需检查上方、左上、右上）
     */
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // 检查正上方同列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // 检查左上方对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // 检查右上方对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}

// 核心思路
// 回溯法：逐行放置皇后，每行尝试所有列位置。
// 用 isValid 检查当前位置是否与已放置的皇后冲突（只需检查上方、左上、右上）。
// 到达最后一行时保存当前棋盘布局。
//
// 时间复杂度: O(n!)，每行可选列数递减
// 空间复杂度: O(n^2)，棋盘 + 递归栈
