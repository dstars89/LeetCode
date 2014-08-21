package LeetCodeOJ;

/*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderList {

	public ListNode reorderList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode fast=head,slow=head;
		while (fast!=null&&fast.next!=null) {//find the half location
			fast=fast.next.next;
			slow=slow.next;
		}
		ListNode second=slow.next;
		slow.next=null;    //make first half end point to null
		second=reverseList(second);
		ListNode first=head; 
		while(second!=null){  // link together
			ListNode tmp=first.next;
			ListNode tmp2=second.next;
			second.next=tmp;
			first.next=second;
			first=tmp;
			second=tmp2;
		}
		return head;
	}
	public ListNode reverseList(ListNode head){
		if(head==null||head.next==null)return head;
		ListNode reverseList = new ListNode(-1);
		ListNode cur=head;
		while(cur!=null){
			ListNode tmp=cur;
			cur=cur.next;
			tmp.next=reverseList.next;
			reverseList.next=tmp;
		}
		return reverseList.next;
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
