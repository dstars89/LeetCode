package LeetCodeOJ;

/*Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
	public void sortColors(int[] A) {
		if (A == null || A.length == 0)
			return;
		int i = -1, j = -1, k = -1;

		for (int p = 0; p < A.length; p++) {
			if (A[p] == 0) {
				A[++k] = 2;
				A[++j] = 1;
				A[++i] = 0;
			} else if (A[p] == 1) {
				A[++k] = 2;
				A[++j] = 1;

			} else if (A[p] == 2) {
				A[++k] = 2;
			}
		}
	}
}
