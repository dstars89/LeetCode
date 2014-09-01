package LeetCodeOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

//队列辅助层序遍历，队列中插入NULL作为层与层之间的间隔
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		List<Integer> contain = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
				TreeNode node = queue.peek();
				queue.poll();
				if(node!=null){
					contain.add(node.val);
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.offer(node.right);
				}
				else {
					res.addFirst(new ArrayList<Integer>(contain));
					contain.clear();
					if(!queue.isEmpty())queue.offer(null);
					
				}
		}
		return res;

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
