package LeetCodeOJ;


/*A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.

Return a deep copy of the list.*/


/*
some writeup to explain the algorithm above

1\the first loop inserts newly copied node into the original linked list right 
after the node being copied. E.g., originally (node 0) -> (node 1) -> ...;
 after the loop, it becomes (node 0) -> (node 0 copy) -> (node 1) -> (node 1 copy) -> ...
2\after the first loop, we know random pointers (p^) for the copied nodes (n^) 
should point to the immediate following nodes of those (p) being pointed by the 
nodes being copied (n). take the example above, if the random pointer of (node 0) 
points at (node 1), then the random pointer of (node 0 copy) points at the immediate
 following node of (node 1), namely (node 1 copy). this is what the second loop does
3\collect copied nodes and reset the original list back*/
public class CopyListwithRandomPointer {
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)return null;
		RandomListNode p=head;
		do {
			RandomListNode next=p.next;
			p.next=new RandomListNode(p.label);
			p.next.next=next;
			p=next;
		} while (p != null);
		p=head;
		do {
			p.next.random=p.random==null?null:p.random.next;
			p=p.next.next;
		} while (p!=null);
		RandomListNode res=new RandomListNode(-1),q=res;
		p=head;
		while (p != null) {
			q.next=p.next;
			p.next=p.next.next;
			p =p.next ;
			q=q.next;
		}
		return res.next;
	}

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
}
