package LeetCodeOJ;

import java.util.HashMap;


/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.*/

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		 if(preorder==null||inorder==null||preorder.length==0||preorder.length==0||preorder.length!=inorder.length)return null;
		 HashMap<Integer, Integer> inorderIndices = new HashMap<Integer, Integer>();
			for (int i = 0; i < inorder.length; i++) {
				inorderIndices.put(inorder[i], i);
			}
		return buildTreeRecur(inorderIndices,preorder,inorder,0,preorder.length-1,0,inorder.length-1);
	        
	    }
	 
	 public TreeNode buildTreeRecur(HashMap<Integer, Integer> inorderIndices,int[] preorder, int[] inorder,int p_start,int p_end,int i_start,int i_end){
		 if(i_start>i_end||p_start>p_end)return null;
		 int rootVal=preorder[p_start];
		 int pos=inorderIndices.get(rootVal);
		 TreeNode node=new TreeNode(rootVal);
		 node.left=buildTreeRecur(inorderIndices,preorder, inorder, p_start+1,p_start+(pos-i_start), i_start, pos-1);
		 node.right=buildTreeRecur(inorderIndices,preorder, inorder, p_start+1+(pos-i_start), p_end, pos+1, i_end);
		 return node;
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
