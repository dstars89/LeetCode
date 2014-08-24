package LeetCodeOJ;


/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/

public class MinimumDepthofBinaryTree {
	
	public int minDepth(TreeNode root) {
		int min=0;
		if (root == null)
			return min;
		if (root.left != null && root.right != null) {
			min = 1 + Math.min(minDepth(root.left), minDepth(root.right));
		} else {
			min = 1 + minDepth(root.left) + minDepth(root.right);//one of the two childs is 0
		}
		return min;
	}
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
