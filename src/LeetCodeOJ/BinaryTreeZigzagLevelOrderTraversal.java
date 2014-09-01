package LeetCodeOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		List<Integer> contain=new ArrayList<Integer>();
		LinkedList<TreeNode> queue1=new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2=new LinkedList<TreeNode>();
		queue1.offer(root);
		while(!queue1.isEmpty()||!queue2.isEmpty()){
			while(!queue1.isEmpty()){
				TreeNode node=queue1.peekLast();
				queue1.pollLast();
				contain.add(node.val);
				if(node.left!=null)queue2.offer(node.left);
				if(node.right!=null)queue2.offer(node.right);
			}
			if(!contain.isEmpty())res.add(new ArrayList<Integer>(contain));
			contain.clear();
			while(!queue2.isEmpty()){
				TreeNode node=queue2.peekLast();
				queue2.pollLast();
				contain.add(node.val);
				if(node.right!=null)queue1.offer(node.right);
				if(node.left!=null)queue1.offer(node.left);
			}
			if(!contain.isEmpty())res.add(new ArrayList<Integer>(contain));
			contain.clear();
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
