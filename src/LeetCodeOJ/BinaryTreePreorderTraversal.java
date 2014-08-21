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
 class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		if(root==null) return result;
	    stack.push(root);
	    while(!stack.isEmpty()){  
	        TreeNode point = stack.peek();  
	        result.add(point.val);
	        stack.pop();  
	        if(point.right != null){
	            stack.push(point.right);
	        }
	        if(point.left != null)  {
	            stack.push(point.left);
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

