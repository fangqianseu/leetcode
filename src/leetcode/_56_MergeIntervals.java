/*
Date:04.07,2019 22:16
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
*/
package leetcode;

import struct.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {
    /**
     * 首先对 start 排序 判断当前 和 上一个的位置：
     * 重合 则更新；不重合 将上一个 放入 res，temp 指向当前
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return null;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> merged = new ArrayList<int[]>();
        merged.add(intervals[0]);
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            // 从 merged中 获取最新的一个 和当前比较
            // 如果的当前 start 》 end ，则添加新的 区间； 否则就更新 merged中的end值为最大的那一个
            if (start > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[]{start, end});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }
        return merged.toArray(new int[][]{});
    }
}