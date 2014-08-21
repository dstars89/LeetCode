package LeetCodeOJ;

/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could
 *  represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.*/

public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
    	if(root==null)return 0;
    	 return sum(root, 0);
    }
    public int sum(TreeNode root, int x) {
        if (root.right == null && root.left == null)
            return 10 * x + root.val;
        int val = 0;
        if (root.left != null)
            val += sum(root.left, 10 * x + root.val);
        if (root.right != null)
            val += sum(root.right, 10 * x + root.val);
        return val;
    }
	
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
