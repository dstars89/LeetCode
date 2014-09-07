package LeetCodeOJ;

/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.*/

public class SearchinRotatedSortedArray {

	public int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		int start = 0, mid = 0, end = A.length - 1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] == target)
				return mid;
			if (A[start] <= A[mid]) {//left half is sorted
				if (A[start] <= target && target <= A[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {//right half is sorted
				if (A[mid] <= target && target <= A[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
	/*
	 * public int search(int[] A, int target) { if(A==null||A.length==0)return
	 * -1; int start=0,mid=0,end=A.length-1; while(start<=end){
	 * mid=(start+end)/2; if(A[mid]==target)return mid; if(A[mid]<target){
	 * if(A[start]>A[end]&&A[mid]<A[start]&&target>=A[start])end=mid-1;//rotated
	 * else start=mid+1;
	 * 
	 * }
	 * 
	 * a、查找区间的尾部元素小于首部元素，这表示查找区间不是全部有序的，
	 * 
	 * b、target不大于查找区间的尾部元素，这表示target在旋转前数组的前半部分，
	 * 
	 * c、中间元素要大于查找区间尾部元素，这表示中间元素在旋转前数组的后半部分。
	 * 
	 * if(A[mid]>target){
	 * if(A[start]>A[end]&&A[mid]>A[end]&&target<=A[end])start=mid+1;//rotated
	 * else end=mid-1; }
	 * 
	 * } return -1; }
	 */
}
