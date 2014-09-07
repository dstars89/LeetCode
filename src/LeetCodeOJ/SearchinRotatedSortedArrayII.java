package LeetCodeOJ;

/*Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.*/

public class SearchinRotatedSortedArrayII {

	/*
	 * To explain why, consider this sorted array 1111115, which is rotated to
	 * 1151111.
	 * Assume left = 0 and mid = 3, and the target we want to search for is 5.
	 * Therefore, the condition A[left] == A[mid] holds true, which leaves us
	 * with only two possibilities:
	 * 
	 * 1、All numbers between A[left] and A[right] are all 1's. 
	 * 2、Different numbers(including our target) may exist between A[left] and A[right].
	 *  As we  cannot determine which of the above is true, the best we can do is to
	 * move left one step to the right and repeat the process again. Therefore,
	 * we are able to construct a worst case input which runs in O(n), for
	 * example: the input 11111111...115.
	 */
	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0)
			return false;
		int start = 0, mid = 0, end = A.length - 1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] == target)
				return true;
			if (A[start] < A[mid]) {//left half is sorted
				if (A[start] <= target && target <= A[mid])
					end = mid - 1;
				else
					start = mid + 1;

			} else if (A[start] > A[mid]) {//right half is sorted
				if (A[mid] <= target && target <= A[end])
					start = mid + 1;
				else
					end = mid - 1;

			}
			else start++;
		}
		return false;
	}
}
