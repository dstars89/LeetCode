package LeetCodeOJ;

import java.util.HashMap;

/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.*/

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	  public TreeNode buildTree(int[] inorder, int[] postorder) {
		  if(postorder==null||inorder==null||postorder.length==0||postorder.length==0||postorder.length!=inorder.length)return null;
			 HashMap<Integer, Integer> inorderIndices = new HashMap<Integer, Integer>();
				for (int i = 0; i < inorder.length; i++) {
					inorderIndices.put(inorder[i], i);
				}
			return buildTreeRecur(inorderIndices,postorder,inorder,0,postorder.length-1,0,inorder.length-1);
		        
		    }
		 
		 public TreeNode buildTreeRecur(HashMap<Integer, Integer> inorderIndices,int[] postorder, int[] inorder,int p_start,int p_end,int i_start,int i_end){
			 if(i_start>i_end||p_start>p_end)return null;
			 int rootVal=postorder[p_end];
			 int pos=inorderIndices.get(rootVal);
			 TreeNode node=new TreeNode(rootVal);
			 node.left=buildTreeRecur(inorderIndices,postorder, inorder, p_start,p_start+(pos-i_start)-1, i_start, pos-1);
			 node.right=buildTreeRecur(inorderIndices,postorder, inorder, p_start+(pos-i_start), p_end-1, pos+1, i_end);
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
