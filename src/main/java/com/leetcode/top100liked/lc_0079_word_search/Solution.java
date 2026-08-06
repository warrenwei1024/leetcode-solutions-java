package com.leetcode.top100liked.lc_0079_word_search;

/**
 * LeetCode 79. 单词搜索
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word。
 * 如果 word 存在于网格中，返回 true；否则返回 false。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中"相邻"单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从每个单元格作为起点尝试搜索
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col) {
        // 所有字符匹配完成
        if (index == word.length()) {
            return true;
        }

        // 越界或字符不匹配
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // 标记当前单元格为已访问（暂存原字符）
        char temp = board[row][col];
        board[row][col] = '#';

        // 向四个方向搜索下一个字符
        boolean found = backtrack(board, word, index + 1, row + 1, col)
                || backtrack(board, word, index + 1, row - 1, col)
                || backtrack(board, word, index + 1, row, col + 1)
                || backtrack(board, word, index + 1, row, col - 1);

        // 回溯：恢复原字符
        board[row][col] = temp;
        return found;
    }
}

// 核心思路
// DFS + 回溯 + 剪枝。遍历网格中每个单元格作为起点，递归探索四个方向。
// 用 '#' 标记已访问单元格避免重复使用，回溯时恢复原字符。
// 任一方向匹配成功即可提前返回 true。
//
// 时间复杂度: O(m * n * 3^L)，L 为单词长度，每个位置最多 3 个有效方向
// 空间复杂度: O(L)，递归栈深度
