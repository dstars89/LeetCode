package LeetCodeOJ;


/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.*/

/*Calculate and maintain 2 DP states:

 pal[i][j] , which is whether s[i..j] forms a pal

 d[i], which is the minCut for s[i..n-1]

 Once we comes to a pal[i][j]==true:

 if j==n-1, the string s[i..n-1] is a Pal, minCut is 0, d[i]=0;
 else: the current cut num (first cut s[i..j] and then cut the rest s[j+1...n-1]) 
 is 1+d[j+1], compare it to the exisiting minCut num d[i], repalce if smaller.
 d[0] is the answer.*/

public class PalindromePartitioningII {
	public int minCut(String s) {
		int min = 0;
		int len = s.length();
		boolean[][] isPa = new boolean[len][len];
		/*
		 * cuts数组，cuts[i] 表示 以 i 开头到len结尾的子串 要达到题意需要的最少切割数 （这样子最终
		 * cuts[0]就是我们要的结果）【初始化 cuts[i] = len - i, 因为最坏情况 以 i
		 * 开头到len结尾的子串要切割数就是每个字符都切一次 】
		 */
		int cuts[] = new int[len + 1];
		if (s == null || s.length() == 0)
			return min;
		for (int i = 0; i < len; ++i) {
			cuts[i] = len - i;// every cuts initialize to the worst value
		}
		for (int i = len - 1; i >= 0; --i) {
			for (int j = i; j < len; ++j) {
				if ((s.charAt(i) == s.charAt(j) && j - i < 2)
						|| s.charAt(i) == s.charAt(j) && isPa[i + 1][j - 1]) {
					isPa[i][j] = true;
					cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
				}
			}
		}
		min = cuts[0];
		return min - 1;
	}
}
