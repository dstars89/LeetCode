package LeetCodeOJ;

/*Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?*/


/*我们可以用递归中序遍历（或者使用栈的非递归中序遍历）来实现，但是这样空间复杂度都是O(n)*/
/*Morris Traversal中序遍历算法，它既没有递归，也没有使用栈，而是用了线索二叉树的思想，
 * 用闲置的右节点指向中序序列中该节点的后缀，遍历后再恢复树的原始指针
 * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
 * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点（即当前节点的左子树的最右节点）。
 *  a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点（利用这个空的右孩子指向它的后缀）。当前节点更新为当前节点的左孩子。 
 *  b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。*/
public class RecoverBinarySearchTree {

/*	public void recoverTree(TreeNode root) {
		//first,second 分别指向两个错误的节点，parent保存中序访问中当前节点的前驱
		TreeNode first=null,second=null,parent=null;
		TreeNode current=root,pre=null;
		while(current!=null){
			if(current.left==null){
				if(parent!=null){
					if(first==null&&current.val<parent.val)first=parent;
					else if(first!=null&&second==null&&current.val>first.val)second=parent;
				}
				parent=current;
				current=current.right;
			}
			else {
				 Find the inorder predecessor of current 
				pre=current.left;
				while(pre.right!=null&&pre.right!=current)pre=pre.right;
				if(pre.right==null){
					//Make current as right child of its inorder predecessor
					pre.right=current;
					current=current.left;
				}
				else {
					 Revert the changes made in if part to restore the original 
					 tree i.e., fix the right child of predecssor 
					if(first==null&&current.val<parent.val)first=parent;
					else if(first!=null&&second==null&&current.val>first.val)second=parent;
					parent=current;
					
					pre.right=null;
					current=current.right;
				}
					
			}
		}
		if(first!=null){
			if(second==null)second=parent;//{0,1}可能出现该情况
			int tmp=first.val;
			first.val=second.val;
			second.val=tmp;
		}
	}*/
	TreeNode first=null,second=null, parent=null;
	public void recoverTree(TreeNode root) {
		inOrder(root);
		if(first!=null){
			if(second==null)second=parent;//{0,1}可能出现该情况
			int tmp=first.val;
			first.val=second.val;
			second.val=tmp;
		}
		
	}
	
	public void inOrder(TreeNode root){
		if(root==null)return;
		if(root.left!=null)inOrder(root.left);
		if(parent!=null){
			if(first==null&&root.val<parent.val)first=parent;
			else if(first!=null&&root.val>first.val){
				second=parent;//两个点已经找到，结束递归。
				return;
			}
		}
		parent=root;
		if(root.right!=null)inOrder(root.right);
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
