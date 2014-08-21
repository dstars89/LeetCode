package LeetCodeOJ;

import java.util.LinkedList;
import java.util.Queue;


/*Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X*/

/*从四条边上为'O'的点开始遍历(BFS/DFS)字符为‘O’的点，被遍历到的'O'点均为未被'X'包围的点，其余'O'点需要被替换为'X'*/

public class SurroundedRegions {
	private class Point {
			int i;
			int j;
			Point(int i, int j) {
				this.i = i;
				this.j = j;
			}
		}

		private int height;
		private int width;

		public void solve(char[][] board) {
			if (board == null || board.length == 0) {
				return;
			}

			this.height = board.length;
			this.width = board[0].length;
			Queue<Point> queue = new LinkedList<Point>();
			for (int i = 0; i < height; ++i) {
				if (board[i][0] == 'O') {//left
					queue.add(new Point(i, 0));
					bfs(queue, board);
				}
				if (board[i][width - 1] == 'O') {//right
					queue.add(new Point(i, width - 1));
					bfs(queue, board);
				}
			}
			for (int j = 1; j < width - 1; ++j) {//top
				if (board[0][j] == 'O') {
					queue.add(new Point(0, j));
					bfs(queue, board);
				}
				if (board[height - 1][j] == 'O') {//bottom
					queue.add(new Point(height - 1, j));
					bfs(queue, board);
				}
			}
			for (int i = 0; i < height; ++i) {
				for (int j = 0; j < width; ++j) {
					if (board[i][j] == 'O') {//change the rest 'O' to 'X'
						board[i][j] = 'X';
					} else if (board[i][j] == '#') { // change the marked '#' to 'O'
						board[i][j] = 'O';
					}
				}
			}
		}

		private void bfs(Queue<Point> queue, char[][] board) {
			while (!queue.isEmpty()) {
				Point pair = queue.poll();
				int i = pair.i;
				int j = pair.j;
				if (i < 0 || i >= height || j < 0 || j >= width || board[i][j] != 'O') {
					continue;
				}
				board[i][j] = '#'; //marked
				queue.add(new Point(i - 1, j));
				queue.add(new Point(i + 1, j));
				queue.add(new Point(i, j - 1));
				queue.add(new Point(i, j + 1));
			}
		}
}
