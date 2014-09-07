package LeetCodeOJ;

/*Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.*/

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;
		int wLen = word.length();
		if (wLen == 0) {
			return true;
		}
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == word.charAt(0)) {// 查找搜索入口
					if (find(board, word, new boolean[row][col], 0, i, j))
						return true;
				}
			}
		}
		return false;

	}

	public boolean find(char[][] board, String word, boolean[][] visited,
			int depth, int i, int j) {
		if (depth == word.length()) {// 记录递归深度不超过单词长度
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| (visited[i][j] == true) || word.charAt(depth) != board[i][j]) {
			return false;
		}

		visited[i][j] = true;

		// top, down, left, right
		boolean res = find(board, word, visited, depth + 1, i - 1, j)
				|| find(board, word, visited, depth + 1, i + 1, j)
				|| find(board, word, visited, depth + 1, i, j - 1)
				|| find(board, word, visited, depth + 1, i, j + 1);
		visited[i][j] = false;// 无结果则恢复
		return res;
	}

}
