/*
Date:06.03,2019 10:14
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
where h is the height of the person and k is the number of people in front of this person
who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/
package leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class _406_QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])  // 相同高度， k 小的在前
                    return a[1] - b[1];
                else               // 不同高度，高度大的在前
                    return b[0] - a[0];
            }
        });

        List<int[]> list = new LinkedList<>();
        // 先将高度大的入列，插入k的位置
        // 高度低的后入列，随意插队，高个子不在意
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[list.size()][]);
    }
}
