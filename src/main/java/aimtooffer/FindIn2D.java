package aimtooffer;

/**
 * by qianfang, at 2019-09-02, 19:23
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 **/
public class FindIn2D {
    public boolean Find(int target, int[][] array) {
        if (null == array || array.length == 0 || array[0].length == 0) {
            return false;
        }

        for (int i = array.length - 1, j = 0; i >= 0 && j < array[0].length; ) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
