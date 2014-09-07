package LeetCodeOJ;

/*Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.*/

public class ScrambleString {

	/*public boolean isScramble(String s1, String s2) {
		return isScrambleRecur(s1,s2);
	}

	
	 * s2[0...j]是否可以由s1[0...i]转换 isScramble(s2[0...j], s1[0...i])，可以分解成 i 个子问题
	 * ( isScramble(s2[0...k], s1[0...k]) && isScramble(s2[k+1...j],
	 * s1[k+1...i]) ) || ( isScramble(s2[0...k], s1[i-k...i]) &&
	 * isScramble(s2[k+1...j], s1[0...i-k-1]) )，（k = 0,1,2 ... i-1，k相当于字符串的分割点)
	 * 只要一个子问题返回ture，那么就表示两个字符串可以转换,递归结束。
	 
	private boolean isScrambleRecur(String s1, String s2) {
	    if(s1==null || s2==null || s1.length()!=s2.length()) return false;
		if(s1.equals(s2))return true;
		char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2)) return false;//2个字符串有不同的字符就直接返回
		int len=s1.length();
		for (int i = 1; i < len; i++) {//i 分割的点
			String s1_left=s1.substring(0, i);
			String s1_right=s1.substring(i);
			String s2_left=s2.substring(0, i);
			String s2_right=s2.substring(i);
			if(isScrambleRecur(s1_left, s2_left) && isScrambleRecur(s1_right, s2_right))
				return true;
			s2_left=s2.substring(0,len-i);
			s2_right=s2.substring(len-i);
			if(isScrambleRecur(s1_left, s2_right) && isScrambleRecur(s1_right, s2_left))
				return true;
		}
		return false;
	}*/
	
	
	/*使用了一个三维数组boolean dp[len+1][len][len],其中第一维为子串的长度，第二维为s1的起始索引，第三维为s2的起始索引。
	dp[k][i][j]表示s1[i...i+k]是否可以由s2[j...j+k]变化得来。*/
	public boolean isScramble(String s1, String s2) {
		 if(s1==null || s2==null || s1.length()!=s2.length()) return false;
		 if(s1.equals(s2))return true;
		 int len=s1.length();
		 char[] c1 = s1.toCharArray();
	     char[] c2 = s2.toCharArray();
		 boolean[][][] dp=new boolean[len+1][len][len];
		 for (int i = 0; i < len; i++) {
			 for (int j = 0; j < len; j++) {
				dp[1][i][j]=c1[i]==c2[j];
			}
		}
		for (int k = 2; k <= len; k++)// 子串的长度
			for (int i = 0; i <= len - k; i++)// s1的起始位置
				for (int j = 0; j <= len - k; j++)// s2的起始位置
				{
					dp[k][i][j] = false;
					for (int m = 1; m < k && !dp[k][i][j]; ++m) {//有一个结果返回为真就停止
						dp[k][i][j] = (dp[m][i][j] && dp[k - m][i + m][j + m])//isScrambleRecur  左左&&右右 
								|| (dp[m][i][j + k - m] && dp[k - m][i + m][j]);//isScrambleRecur  左右&&右左
					}
				}
		return dp[len][0][0];
	}
}
