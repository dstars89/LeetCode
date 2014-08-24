package LeetCodeOJ;

import java.util.LinkedList;


/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.*/

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)return false;
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
	    stack.push(root);
	    while(!stack.isEmpty()){  
	        TreeNode point = stack.peek(); 
	        stack.pop();  
	        if(point.left==null&&point.right==null&&point.val==sum)return true;
	        if(point.right != null){
	        	point.right.val+=point.val;
	            stack.push(point.right);
	        }
	        if(point.left != null)  {
	        	point.left.val+=point.val;
	            stack.push(point.left);
	        }
	    }  
		
		return false;
		/*if(root == null) return false;
	    sum -= root.val;
	    if(root.left == null && root.right==null)  return sum == 0;
	    else return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);*/

	}
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
