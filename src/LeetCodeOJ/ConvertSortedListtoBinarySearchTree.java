package LeetCodeOJ;

/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/


//使用快慢指针寻找中间位置
public class ConvertSortedListtoBinarySearchTree {
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)return null;
		ListNode faster=head,slow=head,preSlow=null;
		while(faster.next!=null&&faster.next.next!=null){
			faster=faster.next.next;
			preSlow=slow;
			slow=slow.next;
		}
		TreeNode node=new TreeNode(slow.val);
		if(preSlow!=null){ //if one or two nodes
			preSlow.next=null;
			node.left=sortedListToBST(head);
		}
		faster=slow.next;
		node.right=sortedListToBST(faster);
		return node;

	}
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
