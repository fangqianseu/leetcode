/*
Date:04.11,2019 22:39
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring. T
he same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

*/
package leetcode;

public class _79_WordSearch {
    /**
     * 回溯法
     * signs 保存已经遍历的方格
     * 每次比较 方格中的字符 和 word 中的字符相同，则继续比较该方格四周的方格
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] signs = new boolean[board.length][board[0].length];

        boolean res = false;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (existCore(board, signs, word, i, j, 0))
                    return true;
            }

        return false;
    }

    private boolean existCore(char[][] board, boolean[][] signs, String word, int i, int j, int index) {
        // 找到条件
        if (index == word.length()) return true;
        // i j 越界
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        // 重复访问 或者 不相等
        if (signs[i][j] || word.charAt(index) != board[i][j])
            return false;

        signs[i][j] = true;
        if (existCore(board, signs, word, i - 1, j, index + 1) ||
                existCore(board, signs, word, i + 1, j, index + 1) ||
                existCore(board, signs, word, i, j - 1, index + 1) ||
                existCore(board, signs, word, i, j + 1, index + 1))
            return true;
        else {
            signs[i][j] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        new _79_WordSearch().exist(new char[][]{{'a', 'a'}}, "aaa");
    }
}
