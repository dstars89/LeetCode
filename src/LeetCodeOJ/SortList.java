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
public class SortList {

public ListNode sortList(ListNode head) {
	if(head==null||head.next==null)return head;
	ListNode mid=head,p=head;
	while(p.next!=null&&p.next.next!=null){//locate the middle of the linklist
		mid=mid.next;
		p=p.next.next;
		}
	ListNode second=sortList(mid.next);
	mid.next=null;//Split the List into two parts
	return merge(sortList(head),second);
    }

public ListNode merge(ListNode h1,ListNode h2){
	ListNode h=new ListNode(-1);
	ListNode p=h;
	while (h1 != null && h2 != null ){  //until one is empty
        if (h1.val <= h2.val){  
            p.next = h1;  
            h1 = h1.next;  
        }else {  
            p.next = h2;  
            h2 = h2.next;  
        }  
        p = p.next;  
    }  
    if(h1 == null){  
        p.next = h2;  
    }else{  
        p.next = h1;  
    }  
      
	return h.next;
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
