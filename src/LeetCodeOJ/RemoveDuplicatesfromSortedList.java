package LeetCodeOJ;



/*Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.*/


public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null)return head;
		ListNode parent=head,next=null;
		while((next=parent.next)!=null){
			if(parent.val==next.val){
				parent.next=next.next;
			}
			else parent=next;
		}
		return head;
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
