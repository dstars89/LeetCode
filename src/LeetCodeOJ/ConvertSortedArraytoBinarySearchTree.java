package LeetCodeOJ;




/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.*/


/*找到数组的中间数据作为根节点，小于中间数据的数组来构造作为左子树，大于中间数据的数组来构造右子树*/
public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0)
			return null;
		return sortedArrayToBSTRecur(num,0,num.length-1);

	}
	public TreeNode sortedArrayToBSTRecur(int[] num,int start,int end){
		if(start>end)return null;//the end condition
		int  middle=(start+end)/2;
		TreeNode node=new TreeNode(num[middle]);
		node.left=sortedArrayToBSTRecur(num, start,middle-1);
		node.right=sortedArrayToBSTRecur(num, middle+1, end);
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
