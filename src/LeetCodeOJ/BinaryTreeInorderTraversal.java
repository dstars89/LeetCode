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
public class BinaryTreeInorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	    if(root == null) return result;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    while(!stack.isEmpty()||root!=null){  
	        if(root!= null)  {
	            stack.push(root);
	            root=root.left;
	            
	        }
	        else {
	        	 root=stack.peek(); 
	        	 result.add(root.val);
	        	 stack.pop(); 
	        	 root=root.right;
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
