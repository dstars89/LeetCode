package LeetCodeOJ;

/*Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		return buildTree(1, n);
	}
	
	public List<TreeNode> buildTree(int start,int end){
		List<TreeNode> res=new ArrayList<TreeNode>();
		if(start>end){
			res.add(null);// 相当于占位符
			return res;
		}
		for (int i = start; i <=end; i++) {
			List<TreeNode> lefts=buildTree(start,i-1);
			List<TreeNode> rights=buildTree(i+1,end);
			for(TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
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
