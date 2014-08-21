package LeetCodeOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePostorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	    if(root == null) return result;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    TreeNode pre = null;  // track the most recently popped node
	    while(!stack.empty()){
	        TreeNode n = stack.peek();

	        // we print cur node when it is a leaf node, or pre is a child of cur node
	        if(n.left == null && n.right == null || 
	              pre != null && 
	              (n.left == pre || n.right == pre)){ 
	            result.add(n.val);
	            pre = n;
	            stack.pop();
	        }
	        else{
	            if(n.right != null) stack.push(n.right);
	            if(n.left != null) stack.push(n.left);
	        }
	    }
	    return result;
	}
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
	}
}
