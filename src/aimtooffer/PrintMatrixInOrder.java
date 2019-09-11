package aimtooffer;

import java.util.ArrayList;

/**
 * @author qianfang, at 2019-09-09, 20:28
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 **/
public class PrintMatrixInOrder {
    public ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int i = 0, j = 0, m = matrix.length - 1, n = matrix[0].length - 1;

        while (i < m && j < n) {
            printHelper(i, j, m, n, matrix);
            i++;
            j++;
            m--;
            n--;
        }

        if (i == m && j <= n) {
            for (int t = j; t <= n; t++) {
                res.add(matrix[i][t]);
            }
        } else if (j == n && i <= m) {
            for (int t = i; t <= m; t++) {
                res.add(matrix[t][n]);
            }
        }
        return res;
    }

    private void printHelper(int i, int j, int m, int n, int[][] matrix) {
        for (int t = j; t < n; t++) {
            res.add(matrix[i][t]);
        }
        for (int t = i; t < m; t++) {
            res.add(matrix[t][n]);
        }

        for (int t = n; t > j; t--) {
            res.add(matrix[m][t]);
        }

        for (int t = m; t > i; t--) {
            res.add(matrix[t][j]);
        }
    }

    public static void main(String[] args) {
        PrintMatrixInOrder printMatrixInOrder = new PrintMatrixInOrder();
        printMatrixInOrder.printMatrix(new int[][]{{1, 2}, {3, 4}});
    }
}
