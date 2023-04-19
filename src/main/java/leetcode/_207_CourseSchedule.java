/*
Date:05.05,2019 22:34
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _207_CourseSchedule {
    /**
     * 统计每个课被指向次数，初始被指向次数为0的肯定是安全的（不在环上）。
     * 每被安全课程指向一次，被指次数减一，
     * 如果被指次数减到0，说明该课程全部指向都来自安全课程，则它也是安全的。
     * 依此进行队列循环。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // courseRelation存储后置节点的所有前置节点集合
        List<List<Integer>> courseRelation = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courseRelation.add(new ArrayList<>());
        }
        // indegree 为每个节点前置节点的个数 入度
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int p = prerequisite[0];
            int q = prerequisite[1];
            courseRelation.get(q).add(p);
            indegree[p]++;
        }

        int res = 0;
        // 首先把入度为0的节点 调处来
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                stack.add(i);
                res++;
            }
        }

        while (!stack.isEmpty()) {
            int v = stack.pop();

            // 把当前节点去掉后  检查他的所有后置节点是否入度为0； 是的话加入 stack 进行循环
            List<Integer> t = courseRelation.get(v);
            for (int i : t) {
                if (--indegree[i] == 0) {
                    res++;
                    stack.push(i);
                }
            }
        }
        return res == numCourses;
    }
}
