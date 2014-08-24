package LeetCodeOJ;


/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.*/

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if(root==null)return true;
		if(treeHeight(root)==-1)return false;
		return true;

	}
	
	public int treeHeight(TreeNode node){
		if(node.left==null&&node.right==null)return 1;
		int rightHeight=0,leftHeight=0;
		if(node.left!=null)leftHeight=treeHeight(node.left);
		if(leftHeight==-1)return -1;
		if(node.right!=null)rightHeight=treeHeight(node.right);
		if(rightHeight==-1)return -1;
		if(Math.abs(rightHeight-leftHeight)>1)return -1;
		else return Math.max(rightHeight, leftHeight)+1;
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
