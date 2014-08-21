package LeetCodeOJ;
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
public class InsertionSortList {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode sortedHead = new ListNode(-1);
		ListNode q = sortedHead,pp, p = head.next;
		sortedHead.next=head;
		head.next=null;
		while ((pp=p )!= null) {
			p=p.next;
			pp.next=null;
			q=sortedHead;
			ListNode qq;
			while ((qq=q.next)!= null) {
				if(pp.val<qq.val){//find the location ,and insert it into the linklist
				q.next=pp;
				pp.next=qq;
				break;
				}
				else if(qq.next==null){//to the tail
						qq.next=pp;
						break;
				}
				else {   //continue to find the location
					q=q.next;
				}
			}
		}
		return sortedHead.next;
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
