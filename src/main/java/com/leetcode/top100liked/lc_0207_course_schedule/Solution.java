package com.leetcode.top100liked.lc_0207_course_schedule;

/**
 * LeetCode 207. 课程表
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses-1。
 * 在选修某些课程之前需要一些先修课程。先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi]，表示如果要学习课程 ai 则必须先学习课程 bi。
 * 请你判断是否可能完成所有课程的学习。如果可以，返回 true；否则，返回 false。
 * <p>
 * 
 * @author weijunjie
 * @date 2026-07-09
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表表示图，graph[i] 表示课程 i 的后续课程列表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree[i] 表示课程 i 的入度（先修课程数）
        int[] indegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            graph.get(prereqCourse).add(course);    // prereqCourse → course
            indegree[course]++;
        }

        // Kahn 算法（BFS 拓扑排序）：入度为 0 的课程入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int taken = 0;    // 已完成的课程数

        while (!queue.isEmpty()) {
            int course = queue.poll();
            taken++;

            // 移除当前课程，将其所有后继课程的入度减一
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // 完成的课程数与总课程数一致则说明无环
        return taken == numCourses;
    }
}

// 核心思路
// 本质是检测有向图是否存在环。使用 Kahn 算法（BFS 拓扑排序）：
// 1. 构建邻接表 + 入度数组
// 2. 入度为 0 的节点入队，逐一处理并减少后继节点入度
// 3. 最后若处理节点数 < 总节点数，说明图中有环，无法完成所有课程
//
// 时间复杂度: O(V + E)，V 为课程数，E 为先修关系数
// 空间复杂度: O(V + E)，邻接表 + 入度数组
