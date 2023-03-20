package aimtooffer;

/**
 * @author qianfang, at 2019-09-12, 15:23
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 **/
public class MoreThanHalf {
    public int moreThanHalf(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int res = array[0];
        int num = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == res) {
                num++;
            } else if (num-- < 0) {
                num = 1;
                res = array[i];
            }
        }

        num = 0;
        for (int i : array) {
            if (i == res) {
                num++;
            }
        }

        return num > array.length / 2 ? res : 0;
    }
}
