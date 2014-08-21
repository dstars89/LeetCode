package LeetCodeOJ;

/*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].*/

public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] A) {
		int pre=0,count=1;
		if(A.length>0)pre=A[0];
		else return 0;
		for (int i = 1; i < A.length; i++) {
			if(pre!=A[i]){
				pre=A[i];
				A[count++]=A[i];
			}
		}
		return count;
	}
}
