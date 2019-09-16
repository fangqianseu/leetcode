package aimtooffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author qianfang, at 2019-09-16, 10:53
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 **/
public class PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        if (numbers == null || numbers.length == 0) {
            return sb.toString();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        Comparator<Integer> comparator = (o1, o2) -> {
            int a = Integer.parseInt(o1 + "" + o2);
            int b = Integer.parseInt(o2 + "" + o1);
            return Integer.compare(a, b);
        };
        Collections.sort(list, comparator);

        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        new PrintMinNumber().PrintMinNumber(new int[]{3, 5, 1, 4, 2});
    }
}
