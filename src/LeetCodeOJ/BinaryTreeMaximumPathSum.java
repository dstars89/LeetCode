package LeetCodeOJ;

/*Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.*/


public class BinaryTreeMaximumPathSum {

	    int maxSum = Integer.MIN_VALUE;
	    
	    public int getMaxSum(TreeNode root) {
	        if(root==null)  return 0;
	        int  max  = root.val;
	        int  lmax = 0;
	        int  rmax = 0;
	        if(root.left!=null) {
	            lmax = getMaxSum(root.left);
	            if(lmax>0) {
	            	max  += lmax;
	            }
	        }
	        if(root.right!=null) {
	            rmax = getMaxSum(root.right);
	            if(rmax>0) {
	            	max  += rmax;
	            }
	        }
	        if (max>maxSum) {
	        	maxSum = max;
	        }
	        return  Math.max(root.val,Math.max(root.val + lmax, root.val + rmax));
	    }
	    
	    public int maxPathSum(TreeNode root) {
	        if(root==null)  return 0;
	        getMaxSum(root);
	        return maxSum;
	    }
	}

	
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
}
