/*
Date:05.03,2019 22:36
Given a 2d grid valueMap of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
*/
package leetcode;

public class _200_NumberofIslands {
    int res = 0;
    boolean[][] sign;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        sign = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (!sign[i][j] && grid[i][j] == '1') {
                    res++;
                    help(i, j, grid);
                }
            }

        return res;
    }

    private void help(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || sign[i][j] || grid[i][j] == '0')
            return;
        sign[i][j] = true;
        help(i - 1, j, grid);
        help(i + 1, j, grid);
        help(i, j - 1, grid);
        help(i, j + 1, grid);
    }

}
