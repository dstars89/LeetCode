package LeetCodeOJ;

/*Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].*/

public class RemoveDuplicatesfromSortedArrayII {

	public int removeDuplicates(int[] A) {
		int pre=0,count=1,begin=1;
		if(A.length>0)pre=A[0];
		else return 0;
		for (int i = 1; i < A.length; i++) {
			if(pre!=A[i]){
				count=1;
				A[begin++]=A[i];
			}
			else {
				if(++count<3)A[begin++]=A[i];
			}
			pre=A[i];
		}
		return begin;
	}
}
