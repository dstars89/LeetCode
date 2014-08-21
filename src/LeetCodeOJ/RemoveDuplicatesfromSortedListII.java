package LeetCodeOJ;



/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3*/


public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null)return head;
		ListNode tempHead=new ListNode(-1);
		tempHead.next=head;
		ListNode multVal=null;
		ListNode preparent=tempHead,parent=preparent.next,next=null;
		while((next=parent.next)!=null){
			if(parent.val==next.val){
				multVal=next;
				parent=next;
				preparent.next=parent;
			}
			else{
				if(multVal!=null&&parent.val==multVal.val){
					preparent.next=next;
					parent=next;
				}
				else {
					preparent = parent;
					parent = next;
				}
			}
			if(multVal!=null&&parent.next==null&&multVal.val==parent.val){//to the tail
				preparent.next=parent.next;
			}

			
		}
		return tempHead.next;
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
