package LeetCodeOJ;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else {
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
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
