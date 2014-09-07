package LeetCodeOJ;

/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the emtpy string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.*/

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		if (T == null || T.length() == 0 || S == null || S.length() == 0)
			return "";
		int M = S.length();
		int N = T.length();
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();

		// use as map ,array is faster than hashmap
		int[] needToFind = new int[256];
		int[] hasFound = new int[256];
		for (int i = 0; i < N; i++) {
			needToFind[t[i]]++;
		}
		int count = 0;
		int minWinSize = Integer.MAX_VALUE;
		int left = 0;
		for (int begin = 0, end = 0; end < M; end++) {
			if (needToFind[s[end]] == 0) {
				continue;
			}
			if (++hasFound[s[end]] <= needToFind[s[end]]) {
				count++;
			}
			if (count == N) {// find a window
				while (needToFind[s[begin]] == 0
						|| (hasFound[s[begin]] > needToFind[s[begin]])) {
					if ((hasFound[s[begin]] > needToFind[s[begin]])) {
						--hasFound[s[begin]];// find the min
					}
					begin++;
				}
				int winSize = end - begin + 1;
				if (winSize < minWinSize) {
					minWinSize = winSize;
					left = begin;
				}
			}
		}
		if (count == N) {
			return S.substring(left,left+minWinSize);
		}
		return "";
	}
}
