package aimtooffer;

/**
 * @author qianfang, at 2019-09-06, 11:33
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 **/
public class ReOrderArray {
    /**
     * 魔改 插入排序
     * <p>
     * n为偶数，不处理
     * n为奇数，0 ~ n-1的偶数后移一位，中间用 n 填补
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                continue;
            }

            // i之前的排序元素，偶数向后移动一位
            int t = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] % 2 != 0) {
                    break;
                }
                array[j + 1] = array[j];
            }
            array[j + 1] = t;
        }
    }

    public static void main(String[] args) {
        int[] l = {2, 4, 6, 1, 3, 5, 7};
        new ReOrderArray().reOrderArray(l);
        for (int i : l) {
            System.out.println(i);
        }
    }
}
