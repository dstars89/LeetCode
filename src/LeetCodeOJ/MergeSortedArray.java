package LeetCodeOJ;

/*Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) 
to hold additional elements from B. The number of elements initialized in A and B are 
m and n respectively.*/

public class MergeSortedArray {
	 public void merge(int A[], int m, int B[], int n) {
		 for(int i=m+n-1;i>=0;i--) 
			 A[i]=(m!=0&&(n==0||A[m-1]>B[n-1]))?A[--m]:B[--n];
	    }
}
