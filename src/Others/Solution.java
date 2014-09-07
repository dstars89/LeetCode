package Others;

import java.util.LinkedList;


public class Solution {
	public int getLongestSubString(String s1,String s2){
		if(s1==null||s2==null)return 0;
		int res=0;
		int m=s1.length(),n=s2.length();
		int [][] dp=new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(s1.charAt(j)==s2.charAt(i)){
					if(i>0&&j>0)dp[i][j]=dp[i-1][j-1]+1;
					else if (i == 0 || j == 0)dp[i][j] = 1;
				}
				res=Math.max(dp[i][j], res);
			}
			
		}
		return res;
	}
	
/*	public int max_diff(TreeNode root){
		if (root == null)
			return 0;
		int max = root.val, min = root.val;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;

			} else {
				root = stack.peek();
				max = Math.max(max, root.val);
				min = Math.min(min, root.val);
				stack.pop();
				root = root.right;
			}
		}
		return max - min;
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}*/
}
