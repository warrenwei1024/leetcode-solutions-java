package com.leetcode.top100liked.lc_0208_implement_trie_prefix_tree;

/**
 * LeetCode 208. 实现 Trie (前缀树)
 * <p>
 * Trie（发音类似 "try"）或者说前缀树是一种树形数据结构，用于高效地存储和检索
 * 字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 * 请你实现 Trie 类：Trie() 初始化前缀树对象、void insert(String word) 插入、
 * boolean search(String word) 查找、boolean startsWith(String prefix) 前缀匹配。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

class TrieNode {
    TrieNode[] children = new TrieNode[26];  // 26 个小写字母
    boolean isWord = false;                   // 标记是否为完整单词
}

public class Solution {

    static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            // 逐字符插入，若子节点不存在则创建
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isWord = true;    // 标记单词结束
        }

        public boolean search(String word) {
            TrieNode node = findNode(word);
            // 找到节点且该节点标记为完整单词
            return node != null && node.isWord;
        }

        public boolean startsWith(String prefix) {
            // 只需找到前缀对应的节点即可
            return findNode(prefix) != null;
        }

        private TrieNode findNode(String s) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    return null;
                }
                node = node.children[idx];
            }
            return node;
        }
    }
}

// 核心思路
// Trie 树的每个节点有 26 个子节点（对应小写字母）和一个 isWord 标记。
// insert：逐字符创建路径，末尾标记 isWord = true。
// search：沿路径查找，必须到达 isWord = true 的节点才算完整匹配。
// startsWith：只要能走完 prefix 的路径即可，不要求 isWord。
//
// insert 时间复杂度: O(len)
// search / startsWith 时间复杂度: O(len)
// 空间复杂度: O(N * 26)，N 为所有插入字符总数
