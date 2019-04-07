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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _56_MergeIntervals {
    /**
     * 首先对 start 排序 判断当前 和 上一个的位置：
     * 重合 则更新；不重合 将上一个 放入 res，temp 指向当前
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        Interval temp = intervals.get(0);
        for (Interval interval : intervals) {
            // 此时区间重合
            if (temp.end >= interval.start) {
                // 更新 end 为  2 个区间 中较大的那个
                temp.end = Math.max(interval.end, temp.end);
            } else {
                res.add(temp);
                temp = interval;
            }
        }
        res.add(temp);
        return res;
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 4);
        Interval interval3 = new Interval(5, 6);
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        new _56_MergeIntervals().merge(list);
    }
}