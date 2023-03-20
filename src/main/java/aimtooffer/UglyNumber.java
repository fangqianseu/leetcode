package aimtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianfang, at 2019-09-16, 15:36
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 **/
public class UglyNumber {

    //注意 可能出现 2 3的倍数相等的情况，顾 if 不加 else
    public int uglyNumber(int index) {
        if (index < 1) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (index == 1) {
            return list.get(index - 1);
        }

        int i2 = 0, i3 = 0, i5 = 0;
        while (index > list.size()) {
            int t2 = 2 * list.get(i2);
            int t3 = 3 * list.get(i3);
            int t5 = 5 * list.get(i5);

            int min = Math.min(t2, Math.min(t3, t5));
            list.add(min);
            if (min == t2) {
                i2++;
            }
            if (min == t3) {
                i3++;
            }
            if (min == t5) {
                i5++;
            }
        }
        return list.get(index - 1);
    }

    public static void main(String[] args) {
        new UglyNumber().uglyNumber(6);
    }
}
