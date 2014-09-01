package LeetCodeOJ;

/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.*/

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if(root==null)return true;
		return isSymmetricRecur(root.left,root.right);

	}
	
	public boolean isSymmetricRecur(TreeNode left,TreeNode right){
		if(left==null&&right==null)return true;
		else if(left!=null&&right!=null&&left.val==right.val)return isSymmetricRecur(left.left, right.right)&&isSymmetricRecur(left.right, right.left);
		else return false;
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
