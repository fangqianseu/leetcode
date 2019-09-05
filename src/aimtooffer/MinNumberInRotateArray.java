package aimtooffer;

/**
 * @author qianfang, at 2019-09-05, 09:10
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 **/
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return helper(array, 0, array.length - 1);
    }

    private int helper(int[] array, int l, int r) {
        if (l >= r) {
            return Math.min(array[l], array[r]);
        }

        int mid = (l + r) / 2;
        if (array[mid] > array[r]) {
            return helper(array, mid + 1, r);
        } else {
            return helper(array, l, mid);
        }
    }
}
