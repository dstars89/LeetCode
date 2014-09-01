package LeetCodeOJ;


/*Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.*/

public class InterleavingString {
	//递归解法：每次比较s1和s3的最后一个字符或者s2和s3的最后一个字符，如果相等去掉两者的最后一个字符进入子问题，只要一个子问题返回true，父问题就返回true
	/*public boolean isInterleave(String s1, String s2, String s3) {
		int n=s1.length();
		int m=s2.length();
		if(s3.length()!=m+n)return false;
		return isInterleaveRescur(s1, n-1, s2, m-1, s3, m+n-1);
	}
	
	public boolean isInterleaveRescur(String s1,int s1_end,String s2,int s2_end,String s3,int s3_end){
		if(s1_end==-1&&s2_end==-1){
			if(s3_end==-1)return true;
			else return false;
		}
		if(s1_end>=0&&s1.charAt(s1_end)==s3.charAt(s3_end)&&isInterleaveRescur(s1, s1_end-1, s2, s2_end, s3, s3_end-1))return true;
		if(s2_end>=0&&s2.charAt(s2_end)==s3.charAt(s3_end)&&isInterleaveRescur(s1, s1_end, s2, s2_end-1, s3, s3_end-1))return true;
		return false;
	}*/
	
	/*
	 * 动态规划解此题。设dp[i][j]表示s1[0...i-1]和s2[0...j-1]能否组合成s3[0....i+j-1]， 动态规划方程如下
	 * dp[i][j] = (dp[i][j-1] ==true && s3[i+j-1] == s2[j-1]) || (dp[i-1][j] ==
	 * true && s3[i-1+j] == s1[i-1]) 初始条件：dp[0][0]=true; 其他值均为false
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		int n=s1.length();
		int m=s2.length();
		if(s3.length()!=m+n)return false;
		boolean[][] dp=new boolean[n+1][m+1];
		dp[0][0] = true;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i > 0)
					dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
				if (j > 0)
					dp[i][j] = dp[i][j]
							|| (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
			}
		}
		return dp[n][m];
	}
}
