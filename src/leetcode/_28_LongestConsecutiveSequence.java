package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qianfang, at 2023/3/16, 08:25
 **/
public class _28_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int i : nums) {
            // 只计算  i-1 不存在的数字 看他的序列最长是多少
            if (!set.contains(i-1)) {
                int c = 1;
                int x = i + 1;
                while (set.contains(x)) {
                    c++;
                    x++;
                }
                res = Math.max(res, c);
            }
        }
        return res;
    }
}
