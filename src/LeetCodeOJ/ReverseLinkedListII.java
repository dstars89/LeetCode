package LeetCodeOJ;

/*Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.*/


public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode nodeHead=new ListNode(0);
		nodeHead.next=head;
		ListNode mPre=null,mP=null,p=nodeHead;
		for (int i = 0; i < m; i++) {
			mPre=p;
			p=p.next;//m 
		}
		ListNode pNext=p.next;
	    mP=p;//backup
		for (int i = 0; i < n-m; i++) {
			//reverse m->n
			ListNode pre = p;
			p = pNext;
			pNext = pNext.next;
			p.next = pre;
		}
		mP.next=pNext;
		mPre.next=p;
		return nodeHead.next;

	}
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
