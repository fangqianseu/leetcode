/*
Date:05.03,2019 22:36
Given a 2d grid valueMap of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
*/
package leetcode;

public class _200_NumberofIslands {
    public int numIslands(char[][] grid) {
        boolean[][] sign = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (check(grid, sign, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(char[][] grid, boolean[][] sign, int i, int j) {
        boolean res = false;
        if (!sign[i][j] && grid[i][j] == '1') {
            mark(grid, sign, i, j);
            res = true;
        }
        return res;
    }

    private void mark(char[][] grid, boolean[][] sign, int i, int j) {
        // 出界情况
        int jmax = grid[0].length;
        int imax = grid.length;

        // 注意 退出条件是 已经遍历过 和 是海洋
        if (i < 0 || j < 0 || i >= imax || j >= jmax || sign[i][j] || grid[i][j] == '0') {
            return;
        }

        sign[i][j] = true;

        mark(grid, sign, i - 1, j);
        mark(grid, sign, i + 1, j);
        mark(grid, sign, i, j - 1);
        mark(grid, sign, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] in = new char[][]{{'1', '1', '1'}, {'1', '1', '1'}, {'1', '1', '1'}};
        System.out.println(new _200_NumberofIslands().numIslands(in));
    }

}
