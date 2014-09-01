package LeetCodeOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/


public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		List<Integer> contain=new ArrayList<Integer>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		while(!queue.isEmpty()){
			TreeNode node=queue.peek();
			queue.poll();
			if(node!=null){
				contain.add(node.val);
				if(node.left!=null)queue.offer(node.left);
				if(node.right!=null)queue.offer(node.right);
			}
			else {
				res.add(new ArrayList<Integer>(contain));
				contain.clear();
				if(!queue.isEmpty())queue.add(null);
				
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
