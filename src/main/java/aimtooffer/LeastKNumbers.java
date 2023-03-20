package aimtooffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author qianfang, at 2019-09-12, 15:39
 * <p>
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 **/
public class LeastKNumbers {

    // 优先队列 堆排序
    public ArrayList<Integer> leastKNumbers(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        if (input == null || input.length == 0 || k == 0 || k > input.length) {
            return res;
        }

        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i : input) {
            if (queue.size() < k) {
                queue.add(i);
            } else if (i < queue.peek()) {
                queue.add(i);
                queue.remove();

            }
        }

        for (int i : queue) {
            res.add(i);
        }
        return res;
    }

    // 快排变种
    public ArrayList<Integer> leastKNumbers2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k < 1 || input.length < k) {
            return res;
        }

        helper(input, k, 0, input.length - 1, res);

        return res;
    }

    private void helper(int[] input, int k, int left, int right, ArrayList<Integer> res) {
        if (left >= right) {
            return;
        }
        int key = input[right], l = left, r = right;

        while (l < r) {
            while (l < r && input[l] <= key) {
                l++;
            }
            swap(input, l, r);
            while (l < r && input[r] >= key) {
                r--;
            }
            swap(input, r, l);
        }
        input[l] = key;
        if (l == k - 1) {
            for (int i = 0; i < k; i++) {
                res.add(input[i]);
            }
        } else if (l < k - 1) {
            helper(input, k, l + 1, right, res);
        } else {
            helper(input, k, left, l - 1, res);
        }
    }

    private void swap(int[] input, int l, int r) {
        int t = input[l];
        input[l] = input[r];
        input[r] = t;
    }

    public static void main(String[] args) {
        LeastKNumbers leastKNumbers = new LeastKNumbers();
        System.out.println(leastKNumbers.leastKNumbers2(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }
}
