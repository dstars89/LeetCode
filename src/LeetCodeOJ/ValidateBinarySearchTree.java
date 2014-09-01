package LeetCodeOJ;


/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.*/


//非递归 ：根据BST中序遍历序列有序的性质判断，只要在中序遍历二叉树的代码基础上加上判断相邻元素关系的语句即可
public class ValidateBinarySearchTree {
	//int pre=Integer.MIN_VALUE;
	TreeNode preNode=null;
	public boolean isValidBST(TreeNode root) {
		if(root==null)return true; // inOrderTraversal
		if(!isValidBST(root.left))return false;
		if(preNode!=null){
			if(root.val<=preNode.val)return false;
		}
		preNode=root;
		return isValidBST(root.right);
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
