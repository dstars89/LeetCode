package LeetCodeOJ;

import java.util.LinkedList;

/*Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
*/
public class FlattenBinaryTreetoLinkedList {

	public void flatten(TreeNode root) {
		if(root==null) return ;
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
	    stack.push(root);
	    TreeNode res=null;
	    while(!stack.isEmpty()){  
	        TreeNode point = stack.peek();  
	        stack.pop();  
	        if(point.right != null){
	            stack.push(point.right);
	        }
	        if(point.left != null)  {
	            stack.push(point.left);
	        }
	        point.left=null;
	        point.right=null;
	        if(res!=null)res.right=point;
	        res=point;
	    }  
		
	}
	
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
}
