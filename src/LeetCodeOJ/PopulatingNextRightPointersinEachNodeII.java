package LeetCodeOJ;

/*Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL*/

public class PopulatingNextRightPointersinEachNodeII {

	public void connect(TreeLinkNode root) {
		if(root==null)return;
		TreeLinkNode pre = null,cur=root,nextHead=null;
	    while(cur!=null) {//get the first node of the next layer
	        while(cur!=null) {
	        	if(cur.left!=null){
	        		if(pre!=null)pre.next=cur.left;
	        		else nextHead=cur.left;
	        		pre=cur.left;
	        	}
	        	if(cur.right!=null){
	        		if(pre!=null)pre.next=cur.right;
	        		else nextHead=cur.right;
	        		pre=cur.right;
	        	}
	        	cur=cur.next;
	        }
	        cur =nextHead ;
	        pre=null;
	        nextHead=null;
	    }
	}
	
	
	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	
}
