package LeetCodeOJ;

import java.util.LinkedList;

/*Given a 2D binary matrix filled with 0'stack and 1'stack, find the largest rectangle containing all ones and return its area.*/

public class MaximalRectangle {

	/*
	 * You can maintain a row length of Integer array H recorded its height of
	 * '1'stack, and scan and update row by row to find out the largest
	 * rectangle of each row.
	 * 
	 * For each row, if matrix[row][i] == '1'. H[i] +=1, or reset the H[i] to
	 * zero. and accroding the algorithm of [Largest Rectangle in Histogram], to
	 * update the maximum area.
	 */
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int rowLen = matrix.length; // row length
		int colLen = matrix[0].length;// column length
		int res = 0;
		int[] h = new int[colLen + 1];// height array
		h[colLen] = 0;//insert dummy 0
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int row = 0; row < rowLen; row++) {
			for (int col = 0; col < colLen + 1; col++) {
				if (col < colLen) {
					if (matrix[row][col] == '1')
						h[col] += 1;
					else
						h[col] = 0;
				}
				if (stack.isEmpty() || h[stack.peek()] <= h[col]) {
					stack.push(col);
				} else {
					while (!stack.isEmpty() && h[col] < h[stack.peek()]) {
						int top = stack.pop();
						res = Math.max(res, h[top]
								* (stack.isEmpty() ? col
										: (col - stack.peek() - 1)));
					}
					stack.push(col);
				}
			}
			stack.clear();
		}
		return res;

	}
}
