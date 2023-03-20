/*
Date:05.05,2019 22:34
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _207_CourseSchedule {
    /**
     * 统计每个课被指向次数，初始被指向次数为0的肯定是安全的（不在环上）。
     * 每被安全课程指向一次，被指次数减一，
     * 如果被指次数减到0，说明该课程全部指向都来自安全课程，则它也是安全的。
     * 依此进行队列循环。
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return false;

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (x == prerequisites[i][0]) {
                    inDegree[prerequisites[i][1]]--;
                    if (inDegree[prerequisites[i][1]] == 0)
                        queue.offer(prerequisites[i][1]);
                }
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0)
                return false;
        }
        return true;
    }
}
