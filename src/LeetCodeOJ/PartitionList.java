package LeetCodeOJ;


/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.*/

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode cur=head;
		ListNode less=new ListNode(0),greater=new ListNode(0),pLess=less,pGreater=greater;//为方便操作，添加头结点
		while(cur!=null){
			if(cur.val<x){
				pLess.next=cur;
				pLess=cur;
			}
			else {
				pGreater.next=cur;
				pGreater=cur;
			}
			cur=cur.next;
		}
		if(pGreater!=null)pGreater.next=null;
		pLess.next=greater.next;
		return less.next;

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
