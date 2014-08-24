package LeetCodeOJ;

import java.util.ArrayList;
import java.util.List;


/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]*/

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		List<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		pathSumHelper(root, -sum+root.val, list, res);
		return res;
	}

	public void pathSumHelper(TreeNode root, int sum, List<Integer> list,
			List<List<Integer>> res) {
		if (root.left == null && root.right == null && sum == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		;
		if (root.left != null) {
			list.add(root.left.val);
			pathSumHelper(root.left, sum + root.left.val, list, res);
			list.remove(list.size() - 1);// restore
		}
		if (root.right != null) {
			list.add(root.right.val);
			pathSumHelper(root.right, sum + root.right.val, list, res);
			list.remove(list.size() - 1);// restore
		}
	}
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
